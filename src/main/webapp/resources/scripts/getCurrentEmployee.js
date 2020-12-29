const currentEmployeeInfo = document.querySelector("#emp-info");
const welcomeMessage = document.querySelector("#welcome-emp");

const getCurrentEmployee = async () => {
    const currentEmployee = await fetch("//localhost:8080/Project_1/current-employee");
    res = await currentEmployee.json();
    console.log(res);

    currentEmployeeInfo.innerHTML = "";
    currentEmployeeInfo.innerHTML = `

         <h4>ID: ${res.id}</h4>
         <br/>
         <h4>First Name: ${res.firstName}</h4>
         <br/>
         <h4>Last Name: ${res.lastName}</h4>
         <br/>
         <h4>Email: ${res.email}</h4>

    `;



//    const idLabel = document.createElement("idLabel");
//    idLabel.innerText = `ID: ${res.id}`;
//    const fNameLabel = document.createElement("fNameLabel");
//    fNameLabel.innerText = `First Name: ${res.firstName}`;
//    const lNameLabel = document.createElement("lNameLabel");
//    lNameLabel.innerText = `Last Name: ${res.lastName}`;
//    const emailLabel = document.createElement("emailLabel");
//    emailLabel.innerText = `Email: ${res.firstName}`;
//
//
//    currentEmployeeInfo.appendChild(idLabel);
//    currentEmployeeInfo.appendChild(fNameLabel);
//    currentEmployeeInfo.appendChild(lNameLabel);
//    currentEmployeeInfo.appendChild(emailLabel);

}

getCurrentEmployee();


























//
//fetch("//localhost:8080/Project_1/current-employee")
//    .then(res => res.json())
//    .then(js => {
//        console.log(js);
//    });





//fetch("//localhost:8080/Project_1/current-employee")
//     .then(response => {
//         console.log(response);
//     })
//     .catch(err =>  {
//            //handle error
//
//     });


