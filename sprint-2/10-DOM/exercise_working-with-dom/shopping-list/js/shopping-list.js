const service = new ShoppingService();

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function displayListTitle() {
    const listTitle = document.getElementById("task-header");
    listTitle.textContent = service.getListTitle();
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
    const groceries = service.getGroceries()
                         .map(grocery => {
                            return {
                            }
                         });

    const groceryListContainer = document.getElementById("todos");

    groceries.forEach(grocery => {
        createGroceryDiv(grocery, groceryListContainer);
    });    
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
}


displayListTitle();
displayGroceries();