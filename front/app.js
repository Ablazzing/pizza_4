let pizzaUrl = "http://localhost:8089/pizza";
let orderUrl = "http://localhost:8089/order";

let pizzas2 = fetch(pizzaUrl)
  .then((response) => response.json())
  .then((body) => addPizzas(body))
  .then(() => addEventListenerToPizza());

function addPizzas(pizzas) {
  let pizzaMenu = document.getElementById("pizza-menu");
  pizzaMenu.innerHTML = pizzas.map((pizza) => createPizzaCard(pizza)).join("");
}

let pizzaBtns = document.getElementsByClassName("pizza-btn");
console.log(pizzaBtns);
let resultBucketHtml = document.getElementById("bucket");
let bucket = {};
let makeOrderBtn = document.getElementById("make-order");

function addEventListenerToPizza() {
  Array.prototype.slice.call(pizzaBtns).forEach((element) => {
    element.addEventListener("click", function () {
      bucket[element.name] = (bucket[element.name] ?? 0) + 1;
      const bucketList = Object.entries(bucket)
        .map(([k, v]) => `<li class="list-group-item">${k} - ${v} шт.</li>`)
        .join("");
      resultBucketHtml.innerHTML = bucketList;
      makeOrderBtn.style.display = "block";
    });
  });
}

makeOrderBtn.addEventListener("click", async function () {
  let response = await fetch(orderUrl, {
    method: "POST",
    body: JSON.stringify(bucket),
  })
    .then((number) => successOrder(number))
    .catch(() => showElementOnTime("order-fail", 3000));
});

async function successOrder(response) {
  let number = await response.text();
  let orderEl = document.getElementById("order-success");
  orderEl.innerHTML = `Заказ успешно принят. Номер ${number}`;
  showElementOnTime("order-success", 3000);
  resultBucketHtml.innerHTML = "Ничего не выбрано";
}

function showElementOnTime(elementId, time) {
  let classList = document.getElementById(elementId).classList;
  classList.toggle("d-none");
  setTimeout(() => {
    classList.toggle("d-none");
  }, time);
}

function createPizzaCard(pizza) {
  return `
  <div class="card me-3" style="width: 18rem">
          <img
            src="${pizza.img_url}"
            class="card-img-top"
            style="height: 250px; width: 250px"
            alt="..."
          />
          <div class="card-body items-align-center">
            <h5 class="card-title text-center">${pizza.name}</h5>
            <p class="card-text text-center p-1">
              ${pizza.description}
            </p>
            <a
              href="#"
              id="pizza-firm"
              class="btn btn-primary pizza-btn"
              name="${pizza.name}"
              >Добавить</a
            >
            <span class="ms-2">${pizza.price} рублей</span>
          </div>
        </div>
`;
}
