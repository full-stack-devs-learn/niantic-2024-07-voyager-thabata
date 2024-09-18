document.addEventListener("DOMContentLoaded", () => {
    const addProduct = document.getElementById("add-products");
    const productName = document.getElementById("productName");
    const categoryId = document.getElementById("categoryId");
    const unitPrice = document.getElementById("unitPrice");

    productName.addEventListener("input", () => {
        addProduct.classList.remove("was-validated");
    });

    categoryId.addEventListener("change", () => {
        addProduct.classList.remove("was-validated");
        validateCategory();
    });

    unitPrice.addEventListener("input", () => {
        addProduct.classList.remove("was-validated");
        validateUnitPrice();
    });

    addProduct.addEventListener("submit", (event) => {
        validateCategory();
        validateUnitPrice();

        if (!addProduct.checkValidity()) {
            event.preventDefault();
            addProduct.classList.add("was-validated");
        }
    });

    function validateCategory() {
        if (categoryId.value === "0") {
            categoryId.setCustomValidity("Please select a category.");
            categoryId.classList.add("is-invalid");
        } else {
            categoryId.setCustomValidity("");
            categoryId.classList.remove("is-invalid");
        }
    }

    function validateUnitPrice() {
        if (parseFloat(unitPrice.value) <= 0) {
            unitPrice.setCustomValidity("Price must be greater than 0.");
            unitPrice.classList.add("is-invalid");
        } else {
            unitPrice.setCustomValidity("");
            unitPrice.classList.remove("is-invalid");
        }
    }
});