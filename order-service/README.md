# Order Service
    This application provides the functionality for ordering products.

## REST API 

| Endpoints | METHOD | Request Body | Status | Response body | Description          |
|-----------|--------|--------------|--------|---------------|----------------------|
| /orders   | GET    |              | 200    | Orders        | Get all the orders.  |
| /orders   | POST   | OrderRequest | 200    | Orders        | Submit a new order.  |
