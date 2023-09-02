# spring-apache-pulsar
- similar ao kafka, se base em produtor - conector - consumidor (publisher/assinante)
- com apache pulsar temos 3 formas de produzir/consumir mensage
  - shared: um produz e n_ consome (dlq fica disponivel para essa modalidade apenas)
  - exclusive: um produz e um consome
  - failover: um produz, um consome e este possui um bkp, caso ele falhe 
