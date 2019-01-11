new Vue({
    el: "#app",
    data: {
        // estatus
        estado: "",
        //namequiz
        nom_cuestionario: null,
        //nameQuestion
        nom_pregunta: null,
        //option
        tipo_pregunta: 0,
        //option1
        opcion_respuesta1: null,
        //option2
        opcion_respuesta2: null,
        //option3
        opcion_respuesta3: null,
        //btn
        botonvf: true,
        //para la respuesta corta
        respuesta_corta: null,
        //btn1,2,3
        boton_multiple1: false,
        boton_multiple2: false,
        boton_multiple3: false,
        //lists
        Cuestionario: [],
        error: [],
        // Json de las pregunntas de opcion multiple listOptionMult
        pregunta_multiple: [],
        // Json de la spreguntas de verdadero y falso listTrueFalse
        preguntavf: [],
        // Json de la pregunta corta listShortAnswer
        pregunta_corta: []

    },
    methods: {
        //checkForm
        fomulario: function () {
            if (this.nom_cuestionario) {
                this.Cuestionario.push({nomb_cuestionario: this.nom_cuestionario, opcionMultiple: this.pregunta_multiple,
                      opcionvf: this.preguntavf, opcionCorta: this.pregunta_corta});
                if(this.Cuestionario.length != 0){
                    this.connect();
                    return true;
                }else{
                    this.errors.push('Cuestionario vacio');
                }
            }
            if (!this.nom_cuestionario) {
                this.errors.push('Se requiere el nombre del cuestionario');
            }
        },
        // addQuiz: funtion
        agregarPregunta: function() {
            switch(this.tipo_pregunta){
                case 1:
                    if (this.nom_pregunta && this.opcion_respuesta1 && this.opcion_respuesta2 && this.opcion_respuesta3) {
                        var lista = [];
                        lista.push({ opciones: this.opcion_respuesta1, respuesta: this.boton_multiple1 });
                        lista.push({ opciones: this.opcion_respuesta2, respuesta: this.boton_multiple2 });
                        lista.push({ opciones: this.opcion_respuesta3, respuesta: this.boton_multiple3 });
                        // aqui remplace algo prueba y opciones y lista arriba
                        this.pregunta_multiple.push({ prueba: this.nom_pregunta, opciones: lista });
                        this.borrar();
                        return true;
                    }else{
                        this.errors.push('Se requiere el nombre del cuestionario o de las preguntas');
                    }
                break;

                case 2:
                    if (this.nom_pregunta) {
                        this.preguntavf.push({ pregunta: this.nom_pregunta, respuesta: this.botonvf });
                        this.borrar();
                        return true;
                    }else{
                        this.errors.push('Se requiere el nombre del cuestionario');
                    }
                break;

                case 3:
                    if (this.nom_pregunta) {
                        this.pregunta_corta.push({ pregunta: this.nom_pregunta, opcion: this.respuesta_corta });
                        this.borrar();
                        return true;
                    }else{
                        this.errors.push('Se requiere el nombre del cuestionario');
                    }
                break;
            }
        },
        
        //setTrueFalse por 
        insertarvf: function(bool){
            this.botonvf = bool;
        },
        //showQuestion por
        mostrarPregunta(tipo_preguntas){
            if(tipo_preguntas == this.tipo_pregunta){
                this.tipo_pregunta = 0;
            }else{
                this.tipo_pregunta = tipo_preguntas;
            }
        },
        //clear por
        borrar: function() {
            this.nom_pregunta = null;
            this.opcion_respuesta1 = null;
            this.opcion_respuesta2 = null;
            this.opcion_respuesta3 = null;
            // el botn lo pongo en false en vez de true
            this.botonvf = true;
            this.boton_multiple1 = false;
            this.boton_multiple2 = false;
            this.boton_multiple3 = false;
        },
        //setTrueFalseBtn por insertarbotnvf y numButton por numerobtn
        insertarbotonvf: function(numerobtn, bool) {
            if(bool == numerobtn){
                return false;
            }else{
                return true;
            }
        },
        //trueFalseBtn por
        opcionBoton: function(numero, bool){
            switch (numero){
                case 1:
                    this.boton_multiple1 = this.insertarbotonvf(this.boton_multiple1, bool);
                break;

                case 2:
                    this.boton_multiple2 = this.insertarbotonvf(this.boton_multiple2, bool);
                break;

                case 3:
                    this.boton_multiple3 = this.insertarbotonvf(this.boton_multiple3, bool);
                break;
            }
        },
        connect() {
            socket = new WebSocket("ws://localhost:4567/index");
            socket.onopen = this.openWs;
            socket.onerror = this.errorWs;
            socket.onmessage = this.messageWs;
        },
        openWs() {
            //connected por conectado
            this.estado = 'conectado';
            var myJSON = JSON.stringify(this.Cuestionario);
            this.sendMessage(myJSON);
        },
        errorWs(evt) {
            this.estado = 'error';
        },
        messageWs(evt) {
            this.cuestionarios = JSON.parse(evt.data);
        },
        sendMessage(msgData) {
            socket.send(msgData);
        }
    }
});