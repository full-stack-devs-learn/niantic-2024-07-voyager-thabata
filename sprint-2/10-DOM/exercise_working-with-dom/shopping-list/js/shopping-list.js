/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function displayListTitle() {
    const listTitle = document.getElementById("title");
    const service = new ShoppingService();
    listTitle.textContent = service.getListTitle();
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayShoppingList() {
    const service = new ShoppingService();
    const shoppingList = service.getShoppingList();
    const shoppingListContainer = document.getElementById("shopping-list");

    shoppingList.forEach(item => {
        createListItem(item, shoppingListContainer);
    });    
}


function createListItem(item, parent){
    const listItem = document.createElement("div");
    listItem.classList.add("list-item");

    buildListItem(item, listItem);
    buildQuantity(item, listItem);

    parent.appendChild(listItem);
}


function buildListItem (item, parent){
    const itemTitle = document.createElement("div");
    itemTitle.classList.add("item");
    itemTitle.textContent = item.title;
    parent.appendChild(itemTitle);
}


function buildQuantity (item, parent){
    const itemQuantity = document.createElement("div");
    itemQuantity.classList.add("quantity");
    itemQuantity.textContent = `Quantity: ${item.quantity}`;
    parent.appendChild(itemQuantity);
}


/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
}


document.addEventListener("DOMContentLoaded", () => {
displayListTitle();
displayShoppingList();
});