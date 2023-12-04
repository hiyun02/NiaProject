let insBarChart;
let insdoughnutChart;

function barChart(ctx, fcst, nm) {
    let label = new Array();
    let dataList = new Array();

    if (insBarChart != undefined) {
        insBarChart.destroy();
    }

    for (let i=0; i< 6; i++){
        console.log(fcst[i].fcst_time);
        label.push(fcst[i].fcst_time.slice(-5));
        dataList.push(fcst[i].fcst_ppltn_max);
    }

    console.log(label);
    insBarChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: label,
            datasets: [{
                label: nm+'인구밀집현황',
                data: dataList,
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

function doughnutChart(ctx2, female, male){

    if (insdoughnutChart != undefined) {
        insdoughnutChart.destroy();
    }

    const data = {
        labels: ["남자", "여자"],
        datasets: [
            {
                label: "성별별 밀집도",
                data: [male,female],
                backgroundColor: [
                    "rgb(255, 99, 132)",
                    "rgb(54, 162, 235)",
                ],
                hoverOffset: 4,
            },
        ],
    };

    insdoughnutChart = new Chart(ctx2, {
        type: "doughnut",
        data,
    });

}