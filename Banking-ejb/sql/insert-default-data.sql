INSERT INTO FIT5042.BANKING_SYSTEM_USER (ID_NUMBER, LAST_NAME, FIRST_NAME, EMAIL, PASSWORD, "TYPE", ADDRESS, phone_number)
	VALUES (1, 'Leung', 'Eddie' , 'eddieleung@student.monash.edu', '1111', 'Public', '24 Boston Avenue Malvern East Victoria 3145','0411234567');
INSERT INTO FIT5042.BANKING_SYSTEM_USER (ID_NUMBER, LAST_NAME, FIRST_NAME, EMAIL, PASSWORD, "TYPE", ADDRESS, phone_number)
	VALUES (2, 'Huang', 'Jennifer' , 'huangjennifer@student.monash.edu', '2222', 'Public', '11 Bettina Street Clayton Victoria 3168','0422334335');
INSERT INTO FIT5042.BANKING_SYSTEM_USER (ID_NUMBER, LAST_NAME, FIRST_NAME, EMAIL, PASSWORD, "TYPE", ADDRESS, phone_number)
	VALUES (3, 'Steller', 'Luke' , 'stellerluke@monashbank.com.au', '3333', 'Bank Worker', '3 Wattle Avenue Glen Huntly Victoria 3163','0409233432');
INSERT INTO FIT5042.BANKING_SYSTEM_USER (ID_NUMBER, FIRST_NAME, EMAIL, PASSWORD, "TYPE", ADDRESS, phone_number)
	VALUES (4, 'Test', 'stellerluke@monashbank.com.au', '3333', 'Bank Worker', '3 Wattle Avenue Glen Huntly Victoria 3163','0409233432');
INSERT INTO FIT5042.BANKING_SYSTEM_USER (FIRST_NAME, EMAIL, PASSWORD, "TYPE", ADDRESS, phone_number)
	VALUES ('Test2', 'stellerluke@monashbank.com.au', '3333', 'Bank Worker', '3 Wattle Avenue Glen Huntly Victoria 3163','0409233432');

INSERT INTO FIT5042.BANKING_TRANSACTION (BANKING_TRANSACTION_NUMBER, BANKING_TRANSACTION_NAME, "TYPE", DESCRIPTION, USER_IDNUMBER) 
	VALUES (1, 'travel', 'Debit', 'travel to the UK', 1);
INSERT INTO FIT5042.BANKING_TRANSACTION (BANKING_TRANSACTION_NUMBER, BANKING_TRANSACTION_NAME, "TYPE", DESCRIPTION, USER_IDNUMBER) 
	VALUES (2, 'salary', 'Credit', 'Aug 2017', 1);
INSERT INTO FIT5042.BANKING_TRANSACTION (BANKING_TRANSACTION_NUMBER, BANKING_TRANSACTION_NAME, "TYPE", DESCRIPTION, USER_IDNUMBER) 
	VALUES (3, 'dinner', 'Debit', 'in CBD', 2);
INSERT INTO FIT5042.BANKING_TRANSACTION (BANKING_TRANSACTION_NUMBER, BANKING_TRANSACTION_NAME, "TYPE", DESCRIPTION, USER_IDNUMBER) 
	VALUES (4, 'salary', 'Credit', 'Sep 2017', 2);