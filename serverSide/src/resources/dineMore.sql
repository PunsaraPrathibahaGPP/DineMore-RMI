DROP database dineMore;
CREATE database dineMore;
USE dineMore;

CREATE TABLE Customer(
	customerID INT,
	customerF_Name VARCHAR(40),
	customerL_Name VARCHAR(40),
	customerAddress VARCHAR(100),
	customerNicNO VARCHAR(30),
	customerTel INT,
	CONSTRAINT PRIMARY KEY(customerID)
);

CREATE TABLE Receptionist(
	receptionistID INT,
	receptionistF_Name VARCHAR(40),
	receptionistL_Name VARCHAR(40),
	receptionistAddress VARCHAR(100),
	receptionistNicNO VARCHAR(30),
	receptionistTel INT,
	CONSTRAINT PRIMARY KEY(receptionistID)
);

CREATE TABLE Chef(
	chefID INT,
	chefF_Name VARCHAR(40),
	chefL_Name VARCHAR(40),
	chefAddress VARCHAR(100),
	chef_NicNO VARCHAR(100),
	chefTel INT,
	CONSTRAINT PRIMARY KEY(chefID)
);

CREATE TABLE BikeRider(
	bikeRider_ID INT,
	bike_NO VARCHAR(80),
	bikeRiderF_Name VARCHAR(40),
	bikeRiderL_Name VARCHAR(40),
	bikeRider_Address VARCHAR(100),
	bikeRider_NicNO VARCHAR(100),
	bikeRider_Tel INT,
	CONSTRAINT PRIMARY KEY(bikeRider_ID)
);

CREATE TABLE PlaceOrder(
	orederID INT,
	customerID INT,
	receptionistID INT,
	chefID INT,
	bikeRider_ID INT,
	orderDate VARCHAR(100),
	orderTime VARCHAR(50),
	appointedTime VARCHAR(50),
	foodTypes VARCHAR(300),
	totalAmmount DECIMAL,
	status VARCHAR(100),
	CONSTRAINT PRIMARY KEY(orederID)
);

CREATE TABLE Food(
	foodID INT,
	foodDescription VARCHAR(40),
	foodPrice double,
	CONSTRAINT PRIMARY KEY(foodID)
);

CREATE TABLE ConfirmedFood(
	confirmedID INT,
	orederID INT,
	foodID INT,
	CONSTRAINT PRIMARY KEY(confirmedID),
	CONSTRAINT FOREIGN KEY(orederID) REFERENCES PlaceOrder(orederID),
	CONSTRAINT FOREIGN KEY(foodID) REFERENCES Food(foodID)
);

CREATE TABLE Delivery(
	delivery_ID INT,
	delivery_Date VARCHAR(40),
	delivery_Time VARCHAR(40),
	delivery_State VARCHAR(40),
	paid_Price DECIMAL,
	total_Price DECIMAL,
	balance DECIMAL,
	CONSTRAINT PRIMARY KEY(delivery_ID)
);













CREATE TABLE ReceptionistLogIn(
  receptionistID INT,
  userName VARCHAR(50),
  password VARCHAR(50),
  CONSTRAINT FOREIGN KEY(receptionistID) REFERENCES Receptionist(receptionistID)
);

CREATE TABLE ChefLogIn(
  chefID INT,
  userName VARCHAR(50),
  password VARCHAR(50),
  CONSTRAINT FOREIGN KEY(chefID) REFERENCES Chef(chefID)
);

CREATE TABLE BikeRiderLogIn(
  bikeRider_ID INT,
  userName VARCHAR(50),
  password VARCHAR(50),
  CONSTRAINT FOREIGN KEY(bikeRider_ID) REFERENCES BikeRider(bikeRider_ID)
);

CREATE TABLE AdminLogIn(
  userName VARCHAR(50),
  password VARCHAR(50)
);


INSERT INTO Food VALUES(1,'Pizza-SelfPack',1000.00);
INSERT INTO Food VALUES(2,'Hamberg',1200.00);
INSERT INTO Food VALUES(3,'Submarine',1450.00);
INSERT INTO Food VALUES(4,'Pizza-FamilyPack',1300.00);
INSERT INTO Food VALUES(5,'Pizza-LargePack',1500.00);
INSERT INTO Food VALUES(6,'HotDog',800.00);
INSERT INTO Food VALUES(7,'ChickenRice-LargePack',650.00);
INSERT INTO Food VALUES(8,'ChickenRice-SmallPack',450.00);
INSERT INTO Food VALUES(9,'ChickenRice-SelfPack',300.00);
INSERT INTO Food VALUES(10,'Coke',300.00);
INSERT INTO Food VALUES(11,'Fruit-Desert',300.00);