
function updateDataOnGrid(response) {
    var rowData = [];

    var columnDefs = [
        {headerName: "ID", field: "m_id"},
        {headerName: "First Name", field: "m_firstName"},
        {headerName: "Last Name", field: "m_lastName"},
        {headerName: "Email", field: "m_email"},
        {headerName: "Update", field: "update",cellRenderer: updateRendererFunc}


    ];

    // for (var i = 0; i < response.length; i++) {
    //
    //     // var updateButton = document.createElement('BUTTON');
    //     // updateButton.className = "update";
    //     // updateButton.addEventListener('click', updateEmployee());
    //     // startGameBtn.setIdAttribute = response[i].m_id;
    //
    //     rowData.push({
    //         id: response[i].m_id,
    //         first: response[i].m_firstName,
    //         last: response[i].m_lastName,
    //         email: response[i].m_email,
    //         // update:"update",
    //     });
    //
    // }

    var gridOptions = {
        columnDefs: columnDefs,
        rowData: rowData
    };

    // lookup the container we want the Grid to use
    var eGridDiv = document.querySelector('#myGrid');

    // create the grid passing in the div to use together with the columns & data we want to use

    new agGrid.Grid(eGridDiv, gridOptions);
    gridOptions.api.setRowData(response);
    gridOptions.api.sizeColumnsToFit();
    gridOptions.api.resetRowHeights();
}

function updateRendererFunc(params) {
    // params.$scope.ageClicked = ageClicked;
    //return '<button ng-click="ageClicked(data.age)" ng-bind="data.age"></button>';
    // return '<button class="update" ng-click=updateEmployee(empId)>Update</button>';
    var butt = document.createElement('BUTTON');
    butt.className = "update";
    butt.textContent = "Update";
    butt.addEventListener('click', updateEmployee());
    return butt;
    // return '<button  id="update" type="submit"  ng-click="updateEmployee()">Update</button>';

}
    function handleSubmitInsertEmployee() {
        // var a =$('#firstName').value;
        var firstName = document.getElementById('firstName').value;
        var lastName = document.getElementById('lastName').value;
        var email = document.getElementById('email').value;
        var form = document.getElementById("insertForm");
        // var reqData = {"firstName": firstName, "lastName": lastName, "email": email};
        $.ajax({
            contentType: "application/x-www-form-urlencoded",
            data: {firstName: firstName, lastName: lastName, email: email},
            method: "POST",
            url: "../InsertServlet",
            success: function (response) {
                if (response) {
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

    function ExecuteUpdateEmployee() {
        var id = document.getElementById('idUpdate').value;
        var firstName = document.getElementById('firstNameUpdate').value;
        var lastName = document.getElementById('lastNameUpdate').value;
        var email = document.getElementById('emailUpdate').value;

        $.ajax({
            contentType: "application/x-www-form-urlencoded",
            data: {id: id,firstName: firstName, lastName: lastName, email: email},

            method: "POST",
            //contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            url: "../UpdateEmployeeServlet",
            success: function (response) {
                if (response) {
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

    function updateEmployee(empid) {
return function () {


    var form = document.getElementById("updateForm");
    form.style.display = "";
}
    }


