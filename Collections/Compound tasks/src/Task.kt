// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    val deliveredProducts = customer.orders.filter { it.isDelivered }.flatMap { it.products }
    return deliveredProducts.maxBy { it.price }
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers
            .flatMap { it.getOrderedProducts() }
            .fold(0) {
                totalProductCount, it ->
                    if (product == it)
                            totalProductCount + 1
                    else
                            totalProductCount
            }
}

fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap { it.products }
