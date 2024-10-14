-- Assuming the 'order_service' schema is already set
SET search_path TO order_service;

-- Insert Orders
INSERT INTO orders (
    customer_id,
    order_date,
    shipping_address,
    total_amount,
    order_status,
    payment_status,
    payment_ref,
    created_date,
    last_modified_date,
    created_by,
    last_modified_by
) VALUES
    (1, NOW(), '123 Elm St, Springfield', 100.00, 'Pending', 'Paid', 'REF123', NOW(), NOW(), 'test_user', 'test_user'),
    (1, NOW(), '123 Elm St, Springfield', 200.00, 'Shipped', 'Paid', 'REF124', NOW(), NOW(), 'test_user', 'test_user'),
    (2, NOW(), '456 Oak St, Springfield', 150.00, 'Pending', 'Unpaid', 'REF125', NOW(), NOW(), 'test_user', 'test_user'),
    (1, NOW(), '123 Elm St, Springfield', 75.50, 'Delivered', 'Paid', 'REF126', NOW(), NOW(), 'test_user', 'test_user'),
    (3, NOW(), '789 Pine St, Springfield', 300.00, 'Pending', 'Paid', 'REF127', NOW(), NOW(), 'test_user', 'test_user'),
    (2, NOW(), '456 Oak St, Springfield', 400.00, 'Shipped', 'Paid', 'REF128', NOW(), NOW(), 'test_user', 'test_user'),
    (1, NOW(), '123 Elm St, Springfield', 50.00, 'Pending', 'Unpaid', 'REF129', NOW(), NOW(), 'test_user', 'test_user'),
    (3, NOW(), '789 Pine St, Springfield', 250.00, 'Shipped', 'Paid', 'REF130', NOW(), NOW(), 'test_user', 'test_user'),
    (1, NOW(), '123 Elm St, Springfield', 125.00, 'Delivered', 'Paid', 'REF131', NOW(), NOW(), 'test_user', 'test_user'),
    (2, NOW(), '456 Oak St, Springfield', 175.00, 'Pending', 'Unpaid', 'REF132', NOW(), NOW(), 'test_user', 'test_user');


-- Assuming the 'order_service' schema is already set


SET search_path TO order_service;

-- Insert Order Items
INSERT INTO order_items (
    order_id,
    sku,
    quantity,
    price_per_unit,
    total_price,
    created_date,
    last_modified_date,
    created_by,
    last_modified_by
) VALUES
    (12, 'SKU123', 2, 50.00, 100.00, NOW(), NOW(), 'test_user', 'test_user'),  -- Linked to order_id 1
    (12, 'SKU124', 1, 200.00, 200.00, NOW(), NOW(), 'test_user', 'test_user'),  -- Linked to order_id 1
    (12, 'SKU125', 3, 50.00, 150.00, NOW(), NOW(), 'test_user', 'test_user'),  -- Linked to order_id 2
    (13, 'SKU126', 1, 75.50, 75.50, NOW(), NOW(), 'test_user', 'test_user'),   -- Linked to order_id 3
    (14, 'SKU127', 1, 50.00, 50.00, NOW(), NOW(), 'test_user', 'test_user'),   -- Linked to order_id 1
    (14, 'SKU128', 4, 100.00, 400.00, NOW(), NOW(), 'test_user', 'test_user'),  -- Linked to order_id 4
    (12, 'SKU129', 2, 75.00, 150.00, NOW(), NOW(), 'test_user', 'test_user'),   -- Linked to order_id 2
    (13, 'SKU130', 2, 125.00, 250.00, NOW(), NOW(), 'test_user', 'test_user'),  -- Linked to order_id 3
    (15, 'SKU131', 1, 250.00, 250.00, NOW(), NOW(), 'test_user', 'test_user'),  -- Linked to order_id 5
    (14, 'SKU132', 5, 20.00, 100.00, NOW(), NOW(), 'test_user', 'test_user');   -- Linked to order_id 4
