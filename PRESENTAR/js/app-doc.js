Vue.http.headers.common['Accept'] = 'application/json';

Vue.component('opmultiple', {
    template: "#template-pregunta_multiple",
    props: ['opmultiple'],
    methods: {
        deleteQuestionOptionM: function (opmultiple) {
            var index = vm.pregunta_multiple.indexOf(opmultiple);
            vm.pregunta_multiple.splice(index, 1);
        }
    }
});

Vue.component('opvf', {
    template: "#template-preguntavf",
    props: ['opvf'],
    methods: {
        deleteQuestionOptionTF: function (opvf) {
            var index = vm.preguntavf.indexOf(opvf);
            vm.preguntavf.splice(index, 1);
        }
    }
});

Vue.component('oprcorta', {
    template: "#template-pregunta_corta",
    props: ['oprcorta'],
    methods: {
        deleteQuestionOptionSA: function (oprcorta) {
            var index = vm.pregunta_corta.indexOf(oprcorta);
            vm.pregunta_corta.splice(index, 1);
        }
    }
});


var vm = new Vue({
    el: "#app",
    data: {
        //estado: "",
        //nameQuiz: '',
        cuestionario:'',
        cod_cuestionario: '',
        //textQuestion: '',        
        pregunta: '',
        // -- option: 0,
        tipo_pregunta: 0,
        //listOptionmultiple: [],
        pregunta_multiple: [],
        //listTrueFalse: [],
        preguntavf: [],
        //listShortAnswer: [],
        pregunta_corta: [],
        //option1: '',
        opcion_r1: '',
        //option2: '',
        opcion_r2: '',
        //option3: '',
        opcion_r3: '',
        //answerTrueFalse: true,
        botonvf: true,
        //answerShortAnswer: '',
        respuesta_corta: '',
        //answer1: false,
        boton_multiple1: false,
        //answer2: false,
        boton_multiple2: false,
        //answer2: false,
        boton_multiple3: false,
        error: [],
       // Cuestionario: []
    },
    methods: {
        connect() {
            socket = new WebSocket("ws://localhost:4567/index");
            socket.onopen = this.openWs;
            socket.onerror = this.errorWs;
            socket.onmessage = this.messageWs;
        },
        openWs() {
            var cuestionario_json ={cuestionario: this.cuestionario, preguntasMultiples: this.pregunta_multiple, preguntasVF: this.preguntavf,
                                    preguntasCortas: this.pregunta_corta};
            var myJSON = JSON.stringify(cuestionario_json);
            this.sendMessage(myJSON);
        },
        errorWs(evt) {
            this.estado = 'error';
        },
        messageWs(evt) {
            this.cuestionarios = evt.data;
        },
        sendMessage(msgData) {
            socket.send(msgData);
        },
        //addQUIZ
        fomulario: function () {
            if (this.cuestionario) {
                if (this.pregunta_multiple.length != 0 || this.preguntavf.length != 0 || this.pregunta_corta.length != 0) {
                    this.connect();
                }else{
                    this.errors.push('Cuestionario vacio')
                }
            }else{
                this.errors.push('Sin nombre de cuestionario')
            }
            /*if (this.nom_cuestionario) {
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
            }*/
        },
        //addQuestionOptionMultiple:
        agregarMultiple: function()
        {
            if (this.pregunta && this.opcion_r1 && this.opcion_r2 && this.opcion_r3) {
                //list
                var arreglo = [];
                arreglo.push({alternativa: this.opcion_r1, rta: this.boton_multiple1});
                arreglo.push({alternativa: this.opcion_r2, rta: this.boton_multiple2});
                arreglo.push({alternativa: this.opcion_r3, rta: this.boton_multiple3});
                this.pregunta_multiple.push({preguntas: this.pregunta, alternativas: arreglo});
                this.borrar(1);
            }else{
                this.errors.push('No hay datos suficientes');
            }

        },

        //addQuestionTrueFalse:
        agregarVF: function(){
            if(this.pregunta){
                this.preguntavf.push({pregunta: this.pregunta, rta: this.botonvf});
                this.borrar(2);
            }else {
                this.errors.push('No hay datos suficientes');
            }
        },
        //addQuestionShortAnswer
        agregarRespuestaCorta: function(){
            if (this.pregunta && this.respuesta_corta){
                this.pregunta_corta.push({pregunta: this.pregunta, rta: this.respuesta_corta});
                this.borrar(3);
            }else{
                this.errors.push('No hay datos suficientes');
            }
        },
        //setTrueFalse
        definirVF: function(booleana){
            this.botonvf = booleana;
        },
        //setOption
        mostrarPregunta(tipo_preguntas){
            if(tipo_preguntas == this.tipo_pregunta){
                this.tipo_pregunta = 0;
            }else{
                this.tipo_pregunta = tipo_preguntas;
            }
        },
       
        borrar: function(contador) {
            switch(contador){
                case 1:
                    this.pregunta = '';
                    this.opcion_r1 = '';
                    this.opcion_r2 = '';
                    this.opcion_r3 = '';
                    this.boton_multiple1 = false;
                    this.boton_multiple2 = false;
                    this.boton_multiple3 = false;
                break;
                case 2:
                    this.pregunta = '';
                    this.botonvf = true;
                break; 

                case 3:
                    this.pregunta = '';
                    this.respuesta_corta = '';
                break;
            }
        }
    }
});