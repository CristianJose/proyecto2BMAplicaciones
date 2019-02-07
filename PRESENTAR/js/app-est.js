Vue.component('pregunta1', {
  props: ['pregunta', 'groupid'],
  template: `
        <div class="form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="radio" :name="groupid" :value="pregunta.rta"> {{pregunta.alternativa}}
            </label        
        </div>
    `
});
Vue.component('pregunta2', {
  props: ['groupid'],
  template: `
        <div class="form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="radio" :name="groupid" value="true">Verdadero
            </label>
            <br>
            <label class="form-check-label">
                <input class="form-check-input" type="radio" :name="groupid" value="false">Falso
            </label>
        </div>
    `
});
Vue.component('pregunta3', {
  props: ['groupid'],
  template: `
        <div id="correcta">
            <label>
                <input class="form-control form-control-sm" type="text" :name="groupid">
            </label>
        </div>
    `
});

var vm = new Vue({
    el: "#app",
    data: {
        // key: '',
        acceso: '',
        // status: '',
        conectar: '',
        // nameUser: '',
        estudiante: '',
        // survey: {},
        cuestionario: {},
        //  answer: [],
        rta: [],
        // estado: 0
        accion: 0
    },
    methods: {
        connect() {
            socket = new WebSocket("ws://localhost:4567/estudiante");
            socket.onopen = this.openWs;
            socket.onerror = this.errorWs;
            socket.onmessage = this.messageWs;
        },
        openWs() {
            this.conectar = "connected";
            this.sendMessage(this.acceso);
        },
        errorWs(evt) {
            alert("No esxiste cuestionario");
        },
        messageWs(evt) {
            this.cuestionario = JSON.parse(evt.data);
            
        },
        sendMessage(msgData) {
            if(this.accion === 0){
                socket.send(msgData);
            }else{
                var myJSON = JSON.stringify(msgData);
                socket.send(myJSON);
            }
        },
        almacenarRta: function(){

            for (var elemento in this.cuestionario.pmultiple) {
                this.acceso = this.cuestionario.pmultiple[elemento].idOpmultiple;
                var texto = null;
                var lista = document.getElementsByName(this.acceso);
                for (var i = 0; i < lista.length; i++) {
                    if (lista[i].checked) {
                        texto = lista[i].value;
                    }  
                }
                this.rta.push({
                preg: this.cuestionario.pmultiple[elemento].pregunta,
                rta: texto
                });
            }
            
            for (var elemento in this.cuestionario.pVF) {
                this.acceso = this.cuestionario.pVF[elemento].idOpvf;
                var texto = null;
                var lista = document.getElementsByName(this.acceso);
                for (var j = 0; j < lista.length; j++) {
                    if (lista[j].checked) {
                        texto = lista[j].value;
                    }  
                }
                this.rta.push({
                preg: this.cuestionario.pVF[elemento].pregunta,
                rta: texto
                });
            }
            
            for (var elemento in this.cuestionario.pRCorta) {
                this.acceso = this.cuestionario.pRCorta[elemento].idOpcorta;
                var texto = document.getElementsByName(this.acceso).value;
                this.rta.push({
                preg: this.cuestionario.pRCorta[elemento].pregunta,
                rta: texto
                });
            }
            this.accion = 1;
            var arreglo = {idQuiz: this.cuestionario.idQuiz, nombreCuest: this.cuestionario.nombreCuest, student: this.estudiante, rtas: this.rta};
            this.sendMessage(arreglo);
        }
    }
});