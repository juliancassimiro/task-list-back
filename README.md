É necessário criar uma tabela no MYSQL para logar as alterações:

```SQL
CREATE  TABLE `changes_log` (

`id`  int(11) NOT NULL,

`table_name`  varchar(255) DEFAULT  NULL,

`operation`  varchar(255) DEFAULT  NULL,

`old_data`  varchar(255) DEFAULT  NULL,

`new_data`  varchar(255) DEFAULT  NULL,

`changed_at`  timestamp  NOT NULL  DEFAULT  current_timestamp(),

`processed`  tinyint(1) NOT NULL  DEFAULT  0

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
```
Após a criação da tabela, crie três triggers para monitorar a tabela "task"
```SQL
DELIMITER $$
CREATE TRIGGER `after_delete_task` AFTER DELETE ON `task` FOR EACH ROW BEGIN
  INSERT INTO changes_log (table_name, operation, old_data, new_data)
  VALUES ('task', 'DELETE', JSON_OBJECT('id', OLD.id, 'title', OLD.title, 'description', OLD.description, 'status', OLD.status, 'priority', OLD.priority), NULL);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_insert_task` AFTER INSERT ON `task` FOR EACH ROW BEGIN
  INSERT INTO changes_log (table_name, operation, old_data, new_data)
  VALUES ('task', 'INSERT', NULL, JSON_OBJECT('id', NEW.id, 'title', NEW.title, 'description', NEW.description, 'status', NEW.status, 'priority', NEW.priority));
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update_task` AFTER UPDATE ON `task` FOR EACH ROW BEGIN
  INSERT INTO changes_log (table_name, operation, old_data, new_data)
  VALUES ('task', 'UPDATE', JSON_OBJECT('id', OLD.id, 'title', OLD.title, 'description', OLD.description, 'status', OLD.status, 'priority', OLD.priority), JSON_OBJECT('id', NEW.id, 'title', NEW.title, 'description', NEW.description, 'status', NEW.status, 'priority', NEW.priority));
END
$$
DELIMITER ;
```
