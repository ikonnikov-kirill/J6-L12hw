select products.title, array_to_string(array_agg(customers.name), ', ')
from products
         inner join orders_products
                    on products.id = orders_products.product_id
         inner join orders
                    on orders_products.order_id = orders.id
         inner join customers
                    on orders.customer_id = customers.id
group by products.title
order by title;

select customers.name, array_to_string(array_agg(products.title), ', ')
from products
         inner join orders_products
                    on products.id = orders_products.product_id
         inner join orders
                    on orders_products.order_id = orders.id
         inner join customers
                    on orders.customer_id = customers.id
group by customers.name
order by customers.name;