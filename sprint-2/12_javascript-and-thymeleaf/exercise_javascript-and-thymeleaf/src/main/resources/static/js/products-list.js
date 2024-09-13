let categoryId = 0;

document.addEventListener("DOMContentLoaded", () => {
    const selectedCategory = document.getElementById('category');

    selectedCategory.addEventListener("change", () => {
        categoryId = selectedCategory.value;
        loadPage();
    });

    function loadPage()
    {
        const container = document.getElementById('product-table');
        container.innerHTML = "";

        const url = `products/category/${categoryId}`;

        fetch(url).then(response => {
            if(response.status === 200)
            {
                return response.text();
            }
            throw new Error(response);
            }).then(data => {
                container.innerHTML = data;
            }).catch(error => {
                console.log(error)
            });
    }
});