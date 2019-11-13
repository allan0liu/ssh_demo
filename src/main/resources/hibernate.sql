CREATE TABLE t_customer(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20),
`address` VARCHAR(50),
`sex` VARCHAR(2)
)

CREATE TABLE t_order(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`money` DOUBLE,
`receiver_info` VARCHAR(50)

)