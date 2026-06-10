const BASE_URL = "http://localhost:8080";

// SECTION SWITCH
function showSection(sectionId){
    // Hide all sections
    document.getElementById("dashboardSection").style.display = "none";
    document.getElementById("userSection").style.display = "none";
    document.getElementById("categorySection").style.display = "none";
    document.getElementById("expenseSection").style.display = "none";

    // Show selected section
    document.getElementById(sectionId).style.display = "block";

    // Highlight active sidebar item
    document.querySelectorAll(".sidebar ul li").forEach(li => li.classList.remove("active"));
    document.querySelector(`.sidebar ul li[onclick="showSection('${sectionId}')"]`).classList.add("active");
}

// Default load
window.onload = () => {
    showSection("dashboardSection");
    loadUsers();
    loadCategories();
    loadExpenses();
    loadDashboard();
};

// USER
function createUser(){
    fetch(BASE_URL + "/users",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify({
            name:document.getElementById("name").value,
            email:document.getElementById("email").value
        })
    })
    .then(res=>res.json())
    .then(()=>{
        alert("User Added");
        loadUsers();
        loadDashboard();
    });
}

// CATEGORY
function createCategory(){
    fetch(BASE_URL + "/categories",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify({name:document.getElementById("categoryName").value})
    })
    .then(res=>res.json())
    .then(()=>{
        alert("Category Added");
        loadCategories();
        loadDashboard();
    });
}

// EXPENSE
function addExpense(){
    const userId=document.getElementById("userId").value;
    const categoryId=document.getElementById("categoryId").value;
    fetch(BASE_URL + `/expenses?userId=${userId}&categoryId=${categoryId}`,{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify({
            amount:document.getElementById("amount").value,
            date:document.getElementById("date").value
        })
    })
    .then(res=>res.json())
    .then(()=>{
        alert("Expense Added");
        loadExpenses();
        loadDashboard();
    });
}

// USERS TABLE + DROPDOWN
function loadUsers(){
    fetch(BASE_URL + "/users")
    .then(res=>res.json())
    .then(data=>{
        let table="";
        let userSelect=document.getElementById("userId");
        userSelect.innerHTML="";
        data.forEach(user=>{
            table += `
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                </tr>`;
            userSelect.innerHTML += `<option value="${user.id}">${user.name}</option>`;
        });
        document.getElementById("userTable").innerHTML=table;
    });
}

// CATEGORY TABLE + DROPDOWN
function loadCategories(){
    fetch(BASE_URL + "/categories")
    .then(res=>res.json())
    .then(data=>{
        let table="";
        let categorySelect=document.getElementById("categoryId");
        categorySelect.innerHTML="";
        data.forEach(cat=>{
            table += `
                <tr>
                    <td>${cat.id}</td>
                    <td>${cat.name}</td>
                </tr>`;
            categorySelect.innerHTML += `<option value="${cat.id}">${cat.name}</option>`;
        });
        document.getElementById("categoryTable").innerHTML=table;
    });
}

// EXPENSE TABLE
function loadExpenses(){
    fetch(BASE_URL + "/expenses")
    .then(res=>res.json())
    .then(data=>{
        let table="";
        let total=0;
        data.forEach(exp=>{
            total += exp.amount;
            table += `
                <tr>
                    <td>${exp.id}</td>
                    <td>₹${exp.amount}</td>
                    <td>${exp.category.name}</td>
                    <td>${exp.date}</td>
                </tr>`;
        });
        document.getElementById("expenseTable").innerHTML=table;
        document.getElementById("totalExpenses").innerText="₹"+total;
    });
}

// DASHBOARD
function loadDashboard(){
    fetch(BASE_URL + "/users")
    .then(res=>res.json())
    .then(data=>{
        document.getElementById("totalUsers").innerText=data.length;
    });

    fetch(BASE_URL + "/categories")
    .then(res=>res.json())
    .then(data=>{
        document.getElementById("totalCategories").innerText=data.length;
    });
}
