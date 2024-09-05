let service;
let list = []

let allItemsIncomplete = true;


function displayListTitle() {
    const title = document.getElementById("title")
    title.textContent = service.getListName();
}


function displayShoppingList() {
    const parent = document.getElementById("shopping-list")

    list.forEach(item => {
        addListItem(item, parent);
    })
}


function handleItemClick(event) {
    const item = event.currentTarget;
    if (!item.classList.contains("complete")) {
        item.classList.add("complete");
    }
}


function handleItemDoubleClick(event) {
    const item = event.currentTarget;
    if (item.classList.contains("complete")) { 
        item.classList.remove("complete");
    }
}


function addListItem(item, parent) {
    const div = document.createElement("div")
    div.classList.add("list-item");
    if(item.isComplete)
    {
        div.classList.add("complete")
    }

    addItemTitle(item, div);
    addQuantity(item, div)

    div.addEventListener("click", handleItemClick);   
    div.addEventListener("dblclick", handleItemDoubleClick); 

    parent.appendChild(div)
}


function addItemTitle(item, parent) {
    const div = document.createElement("div")
    div.textContent = item.title;

    parent.appendChild(div);
}


function addQuantity(item, parent) {
    const div = document.createElement("div");
    div.classList.add("quantity-container");

    const span = document.createElement("span");
    span.textContent = "quantity"
    span.classList.add("super");

    const text = document.createTextNode(item.quantity)

    div.appendChild(span)
    div.appendChild(text)

    parent.appendChild(div);
}


function addNewItem(event) {
    event.preventDefault();

    const itemNameInput = document.getElementById("itemName");
    const quantityInput = document.getElementById("quantity");

    const itemName = itemNameInput.value.trim(); 
    const quantity = quantityInput.value.trim();

    if (itemName && quantity) { 
        
        const newItem = {
            id: list.length + 1,
            title: itemName,
            quantity: parseInt(quantity, 10), 
            isComplete: false
        };

        list.push(newItem);

        const parent = document.getElementById("shopping-list");
        addListItem(newItem, parent);

        itemNameInput.value = "";
        quantityInput.value = "";
    }
}


function markItemCompleted(event) {
    onclick = document.getElementById('itemName')
    event.markCompleted

}


function markCompleted() {
    const listItems = document.querySelectorAll(".list-item");

    listItems.forEach(item => {
        item.classList.add("complete");
    })
}


function toggleAllItems() {
    const listItems = document.querySelectorAll(".list-item");
    const button = document.getElementById("allCompleteButton");

    if (allItemsIncomplete) {
        listItems.forEach(item => item.classList.add("complete"));
        button.textContent = "Mark All Incomplete";
        allItemsIncomplete = false;
    } else {
        listItems.forEach(item => item.classList.remove("complete"));
        button.textContent = "Mark All Complete";
        allItemsIncomplete = true;
    }
}


document.addEventListener("DOMContentLoaded", () => {
    service = new ShoppingService();
    list = service.getShoppingList();

    displayListTitle();
    displayShoppingList();

    const toggleAllButton = document.getElementById("allCompleteButton");
    toggleAllButton.addEventListener("click", toggleAllItems);

    const form = document.querySelector("form");
    form.addEventListener("submit", addNewItem);
});