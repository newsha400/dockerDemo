console.log("1")
const Http = new XMLHttpRequest();
const url='http://localhost:8080/dockerps';
Http.open("GET", url);
Http.send();
console.log("2")

Http.onreadystatechange=(e)=>{
    if(Http.readyState == 4 && Http.status ==200){
        console.log("3")

        const responseText = Http.responseText;
        const response = JSON.parse(responseText);
        var tableRow = "";
        var innerHTML = "";

        for (var i = 0 ; i < response.length ; i++){
            console.log("4")

            tableRow = '<tr>';
            tableRow += '<td>' + response[i].containerId + '</td>';
            tableRow += '<td>' + response[i].image + '</td>';
            tableRow += '<td>' + response[i].command + '</td>';
            tableRow += '<td>' + response[i].created + '</td>';
            tableRow += '<td>' + response[i].status + '</td>';
            tableRow += '<td>' + response[i].ports + '</td>';
            tableRow += '<td>' + response[i].names + '</td>';
            tableRow += '</tr>';
            innerHTML += tableRow;
        }
        console.log(innerHTML)
        console.log("5")

        document.getElementById("table").innerHTML += innerHTML;
    }
}
