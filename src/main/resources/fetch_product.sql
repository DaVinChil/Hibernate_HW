select product_name
from homework.orders
         join homework.customers
              on homework.customers.id = homework.orders.customer_id
where LOWER(name) = :customer_name
