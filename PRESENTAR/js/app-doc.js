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
        cuestionario:'', 
        pregunta: '',
        tipo_pregunta: 0,
        pregunta_multiple: [],
        preguntavf: [],
        pregunta_corta: [],
        opcion_r1: '',
        opcion_r2: '',
        opcion_r3: '',
        botonvf: true,
        respuesta_corta: '',
        boton_multiple1: false,
        boton_multiple2: false,
        boton_multiple3: false,
        error: [],
    },
    methods: {
        
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
           
        },
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
        agregarVF: function(){
            if(this.pregunta){
                this.preguntavf.push({pregunta: this.pregunta, rta: this.botonvf});
                this.borrar(2);
            }else {
                this.errors.push('No hay datos suficientes');
            }
        },
        agregarRespuestaCorta: function(){
            if (this.pregunta && this.respuesta_corta){
                this.pregunta_corta.push({pregunta: this.pregunta, rta: this.respuesta_corta});
                this.borrar(3);
            }else{
                this.errors.push('No hay datos suficientes');
            }
        },
        definirVF: function(booleana){
            this.botonvf = booleana;
        },
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
        },

        connect() {
            socket = new WebSocket("ws://localhost:4567/profesor");
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
        }
    }
});
