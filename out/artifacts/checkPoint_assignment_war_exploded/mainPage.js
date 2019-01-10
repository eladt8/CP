function updateDataOnGrid(response) {
    var rowData = [];

    var columnDefs = [
        {headerName: "ID", field: "id"},
        {headerName: "First Name", field: "first"},
        {headerName: "Last Name", field: "last"},
        {headerName: "Email", field: "email"},
        {headerName: "Update", field: "update"}

    ];

    for (var i = 0; i < response.length; i++) {

        rowData.push({
            id: response[i].m_id,
            first: response[i].m_firstName,
            last: response[i].m_lastName,
            email: response[i].m_email,
            update:"update"
        });

    }

    // specify the data
    //     = [
    //     {id: "123", first: "elad", last: "tanaami", email:"sad@gmail.com"},
    //     {id: "123", first: "bar", last: "cohen", email:"sadsad@gmail.com"},
    //     {id: "123", first: "dani", last: "naeem", email:"fsa@gmail.com"}
    // ];

    // let the grid know which columns and what data to use
    var gridOptions = {
        columnDefs: columnDefs,
        rowData: rowData
    };

    // lookup the container we want the Grid to use
    var eGridDiv = document.querySelector('#myGrid');

    // create the grid passing in the div to use together with the columns & data we want to use
    new agGrid.Grid(eGridDiv, gridOptions);

}

function handleSubmitInsertEmployee() {
    // var a =$('#firstName').value;
    var firstName=document.getElementById('firstName').value;
    var lastName=document.getElementById('lastName').value;
    var email=document.getElementById('email').value;
    var form = document.getElementById("insertForm");
    var reqData = {"firstName": firstName,"lastName":lastName, "email":email};
      $.ajax({
        type: "POST",
        contentType: 'application/json',
         data: {firstName: firstName,lastName:lastName,email:email},
        //contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        url: "../InsertServlet",
        success: function (response) {
            if(response)
            {
                //lrt the user know
            }
             form.style.display = "none";

        },
        error: function (response) {
            // loader.style.display = "none";
            window.alert("Something Went Wrong : " + response.status + " " + response.statusText);
        }
    });


}
function handleInsertEmployee() {
    var form = document.getElementById("insertForm");
    form.style.display = "";
    // var reqData = {"data": document.getElementById("SearchBox").value};//get input from user
    // $.ajax({
    //     type: "GET",
    //     contentType: 'application/json',
    //     //contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
    //     url: "/ItunesSearch_war_exploded3/itunesSearch",
    //     data: reqData,
    //     success: function (response) {
    //         loader.style.display = "none";
    //         HandleResponse(response);
    //     },
    //     error: function (response) {
    //         loader.style.display = "none";
    //         window.alert("Something Went Wrong : " + response.status + " " + response.statusText);
    //     }
    // });
}

function handleShowEmployees() {
    var divGrid = document.getElementById("myGrid");
    divGrid.style.display = "";
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        //contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        url: "../InsertServlet",
        success: function (response) {
            updateDataOnGrid(response);
            // loader.style.display = "none";

        },
        error: function (response) {
            // loader.style.display = "none";
            window.alert("Something Went Wrong : " + response.status + " " + response.statusText);
        }
    });


}