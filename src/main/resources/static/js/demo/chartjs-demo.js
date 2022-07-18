$(function () {

    /*var lineData = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [

            {
                label: "Data 1",
                backgroundColor: 'rgba(26,179,148,0.5)',
                borderColor: "rgba(26,179,148,0.7)",
                pointBackgroundColor: "rgba(26,179,148,1)",
                pointBorderColor: "#fff",
                data: [28, 48, 40, 19, 86, 27, 90]
            },{
                label: "Data 2",
                backgroundColor: 'rgba(220, 220, 220, 0.5)',
                pointBorderColor: "#fff",
                data: [65, 59, 80, 81, 56, 55, 40]
            }
        ]
    };

    var lineOptions = {
        responsive: true
    };


    var ctx = document.getElementById("lineChart").getContext("2d");
    new Chart(ctx, {type: 'line', data: lineData, options:lineOptions});*/

    var barData = {
        labels: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho"],
        datasets: [
            {
                label: "Resolvidas",
                backgroundColor: '#899d1b',
                pointBorderColor: "#fff",
                data: [65, 59, 80, 81, 56, 32]
            },
            {
                label: "Em Andamento",
                backgroundColor: '#fee100',
                pointBorderColor: "#fff",
                data: [65, 59, 80, 81, 56, 65]
            },
            {
                label: "Não Resolvidas",
                backgroundColor: '#ff0500',
                borderColor: "rgba(26,179,148,0.7)",
                pointBackgroundColor: "rgba(26,179,148,1)",
                pointBorderColor: "#fff",
                data: [28, 48, 40, 19, 86, 90]
            }
        ]
    };

    var barOptions = {
        responsive: true
    };


    var ctx2 = document.getElementById("barChart").getContext("2d");
    new Chart(ctx2, {type: 'bar', data: barData, options:barOptions});
    
    
    
    
    
    
    
    
    
    
    
    
    
    var barData = {
        labels: ["Maputo", "Gaza", "Tete", "Cabo Delgado", "Beira"],
        datasets: [
            {
                label: "Resolvidas",
                backgroundColor: '#899d1b',
                pointBorderColor: "#fff",
                data: [65, 59, 80, 81, 56]
            },
            {
                label: "Em Andamento",
                backgroundColor: '#fee100',
                pointBorderColor: "#fff",
                data: [65, 59, 80, 81, 56]
            },
            {
                label: "Não Resolvidas",
                backgroundColor: '#ff0500',
                borderColor: "rgba(26,179,148,0.7)",
                pointBackgroundColor: "rgba(26,179,148,1)",
                pointBorderColor: "#fff",
                data: [28, 48, 40, 19, 86]
            }
        ]
    };

    var barOptionsProvincia = {
        responsive: true
    };


    var ctxProvincia = document.getElementById("chartProvincia").getContext("2d");
    new Chart(ctxProvincia, {type: 'bar', data: barData, options:barOptionsProvincia});
    
    
    
    
    
    
    
    
    

  /*  var polarData = {
        datasets: [{
            data: [
                300,140,200,250
            ],
            backgroundColor: [
                "#EF5350", "#66BB6A", "#b5b8cf","#FFA726"
            ],
            label: [
                "My Radar chart"
            ]
        }],
        labels: [
            "Contacto pessoal","Plataforma","Telefone", "Reunião comunitária"
        ]
    };
    
    var polarOptions = {
        segmentStrokeWidth: 2,
        responsive: true

    };
    

    var ctx3 = document.getElementById("polarChart").getContext("2d");
    new Chart(ctx3, {type: 'polarArea', data: polarData, options:polarOptions});
    */
    
    
    
    

    var doughnutData = {
        labels: ["Contacto pessoal","Plataforma","Telefone", "Reunião comunitária" ],
        datasets: [{
            data: [300,50,100,250],
            backgroundColor: ["#EF5350", "#66BB6A", "#b5b8cf","#FFA726"]
        }]
    } ;
    
    var doughnutOptions = {
        responsive: true
    };

    var ctx4 = document.getElementById("doughnutChart").getContext("2d");
    new Chart(ctx4, {type: 'pie', data: doughnutData, options:doughnutOptions});
    
    
    
    
    
    
    
    
    
    var doughnutDatac = {
        labels: ["Ambiental","Social","Desempenho do Projecto" ],
        datasets: [{
            data: [300,50,100],
            backgroundColor: ["#EF5350", "#66BB6A", "#0277BD","#FFA726"]
        }]
    } ;
    
    var doughnutOptionsc = {
        responsive: true
    };

    var ctx12 = document.getElementById("doughnutChartt").getContext("2d");
    new Chart(ctx12, {type: 'doughnut', data: doughnutDatac, options:doughnutOptionsc});
    
    
    
    

    
    
    
    
    
    
    

    var doughnutDatas = {
        labels: ["Masculino","Feminino","ND"],
        datasets: [{
            data: [130,145,50],
            backgroundColor: ["#EF5350", "#66BB6A", "#b5b8cf","#FFA726"]
        }]
    } ;
    
    var doughnutOptionss = {
        responsive: true
    };

    var ctx90 = document.getElementById("doughnutCharts").getContext("2d");
    new Chart(ctx90, {type: 'pie', data: doughnutDatas, options:doughnutOptionss});
    
    
    
    
    
    
    
    
    
    var doughnutDatact = {
        labels: ["Reclamação","Sugestão","Consulta" ],
        datasets: [{
            data: [231,66,34],
            backgroundColor: ["#EF5350", "#66BB6A", "#0277BD","#FFA726"]
        }]
    } ;
    
    var doughnutOptionsct = {
        responsive: true
    };

    var ctx121 = document.getElementById("doughnutCharttc").getContext("2d");
    new Chart(ctx121, {type: 'doughnut', data: doughnutDatact, options:doughnutOptionsct});
    
    
    
    

    
    
    
    
    
    
    
    
    


    var radarData = {
        labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
        datasets: [
            {
                label: "My First dataset",
                backgroundColor: "rgba(220,220,220,0.2)",
                borderColor: "rgba(220,220,220,1)",
                data: [65, 59, 90, 81, 56, 55, 40]
            },
            {
                label: "My Second dataset",
                backgroundColor: "rgba(26,179,148,0.2)",
                borderColor: "rgba(26,179,148,1)",
                data: [28, 48, 40, 19, 96, 27, 100]
            }
        ]
    };

    var radarOptions = {
        responsive: true
    };

    var ctx5 = document.getElementById("radarChart").getContext("2d");
    new Chart(ctx5, {type: 'radar', data: radarData, options:radarOptions});

});