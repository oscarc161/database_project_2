let data, customers;

async function init_customers(){
let link = "https://opulent-computing-machine-4jw47r569wwrfwpx-8000.app.github.dev/";
let route = "foods";
info = await fetch(link + route);
customers = await info.json();
generateCards_customers(customers);
console.log(customers);
}

async function init_customers2(){
let link = "https://opulent-computing-machine-4jw47r569wwrfwpx-8100.app.github.dev/";
let route = "foods2";
info = await fetch(link + route);
customers = await info.json();
generateCards_customers(customers);
console.log(customers);
}

function generateCards_customers(customers){
  let output = document.getElementById("centerpanel");
  let build = "";
  for(let i=0; i<customers.length; i++){
    let customer = customers[i];
    build += '<div class="card">';
    build += `<h1>${customer.Name}</h1>`;
    build += `<h2>Product Id: ${customer.Food_Id}</h2>`;
    build += `<h3>Cost: ${customer.Price}$</h3>`;
    build += `<p> ${customer.Description}</p>`;
    build += `<hr>`;
    build += '</div>'
  }
   output.innerHTML = build;

}

function filter_customers(){
  let Food_Id = document.getElementById("filter").value;

  let new_ID = [];
  for(let i = 0; i<customers.length; i++){
    if(customers[i].Food_Id == Food_Id){
      new_ID.push(customers[i]);
    }
  }
  generateCards_customers(new_ID)
}