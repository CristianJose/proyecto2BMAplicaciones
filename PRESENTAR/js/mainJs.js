new Vue({
    el: "#app",
    data: {
        status: "",
        nameQuiz: null,
        nameQuestion: null,
        option: 0,
        option1: null,
        option2: null,
        option3: null,
        option4: null,
        btn: true,
        btn1: false,
        btn2: false,
        btn3: false,
        btn4: false,
        lists: [],
        errors: [],
        // option multiple
        listOptionMult: [],
        // true/false
        listTrueFalse: [],
        // short answer
        listShortAnswer: []

    },
    methods: {
        checkForm: function () {
            if (this.nameQuiz) {
                this.lists.push({nameQuiz: this.nameQuiz, optionMultiple: this.listOptionMult,
                      optionTrueFalse: this.listTrueFalse, optionShortAnswer: this.listShortAnswer});
                if(this.lists.length != 0){
                    this.connect();
                    return true;
                }else{
                    this.errors.push('Quiz empty');
                }
            }
            if (!this.nameQuiz) {
                this.errors.push('Name Quiz required.');
            }
        },
        addQuiz: function() {
            switch(this.option){
                case 1:
                    if (this.nameQuestion && this.option1 && this.option2 && this.option3 && this.option4) {
                        var list = [];
                        list.push({ option: this.option1, answer: this.btn1 });
                        list.push({ option: this.option2, answer: this.btn2 });
                        list.push({ option: this.option3, answer: this.btn3 });
                        list.push({ option: this.option4, answer: this.btn4 });
                        this.listOptionMult.push({ question: this.nameQuestion, options: list });
                        this.clear();
                        return true;
                    }else{
                        this.errors.push('Name Question or answers required');
                    }
                break;

                case 2:
                    if (this.nameQuestion) {
                        this.listTrueFalse.push({ question: this.nameQuestion, answer: this.btn });
                        this.clear();
                        return true;
                    }else{
                        this.errors.push('Name Question required.');
                    }
                break;

                case 3:
                    if (this.nameQuestion) {
                        this.listShortAnswer.push({ question: this.nameQuestion });
                        this.clear();
                        return true;
                    }else{
                        this.errors.push('Name Question required.');
                    }
                break;
            }
        },
        setTrueFalse: function(bool){
            this.btn = bool;
        },
        showQuestion(option){
            if(option == this.option){
                this.option = 0;
            }else{
                this.option = option;
            }
        },
        clear: function() {
            this.nameQuestion = null;
            this.option1 = null;
            this.option2 = null;
            this.option3 = null;
            this.option4 = null;
            this.btn = true;
            this.btn1 = false;
            this.btn2 = false;
            this.btn3 = false;
            this.btn4 = false;
        },
        setTrueFalseBtn: function(numButton, bool) {
            if(bool == numButton){
                return false;
            }else{
                return true;
            }
        },
        trueFalseBtn: function(number, bool){
            switch (number){
                case 1:
                    this.btn1 = this.setTrueFalseBtn(this.btn1, bool);
                break;

                case 2:
                    this.btn2 = this.setTrueFalseBtn(this.btn2, bool);
                break;

                case 3:
                    this.btn3 = this.setTrueFalseBtn(this.btn3, bool);
                break;

                case 4:
                    this.btn4 = this.setTrueFalseBtn(this.btn4, bool);
                break;
            }
        },
        connect() {
            socket = new WebSocket("ws://localhost:4567/teacher");
            socket.onopen = this.openWs;
            socket.onerror = this.errorWs;
            socket.onmessage = this.messageWs;
        },
        openWs() {
            this.status = 'connected';
            var myJSON = JSON.stringify(this.lists);
            this.sendMessage(myJSON);
        },
        errorWs(evt) {
            this.status = 'error';
        },
        messageWs(evt) {
            this.survey = JSON.parse(evt.data);
        },
        sendMessage(msgData) {
            socket.send(msgData);
        }
    }
});