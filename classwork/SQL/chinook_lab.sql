--2.1
SELECT
    *
FROM
    employee;

SELECT
    *
FROM
    employee
WHERE
    lastname = 'King';

SELECT
    *
FROM
    employee
WHERE
    firstname = 'Andrew'
    AND reportsto IS NULL;

--2.2

SELECT
    *
FROM
    album
ORDER BY
    title DESC;

SELECT
    firstname
FROM
    customer
ORDER BY
    firstname ASC;

--2.3

SELECT
    *
FROM
    genre;

INSERT INTO genre VALUES (
    26,
    'Electro Swing'
);

INSERT INTO genre VALUES (
    27,
    'Lo Fi'
);

INSERT INTO employee VALUES (
    9,
    'Haugh',
    'Michael',
    'Intern',
    3,
    DATE '1995-03-21',
    DATE '2020-01-22',
    '123 Bruce B Downs BLVD',
    'Tampa',
    'florida',
    'USA',
    '32562',
    '301-789-4106',
    '>fax in 2020',
    'mhaugh95@gmail.com'
);

INSERT INTO employee (
    employeeid,
    lastname,
    firstname,
    title,
    reportsto,
    address,
    city,
    state,
    postalcode,
    phone,
    fax,
    email
) VALUES (
    10,
    'Dave',
    'Big',
    'Rapper',
    1,
    'Main Street',
    'New York',
    'New York',
    '20002',
    '666-BIG-DAVE',
    '666-666-6666',
    'thedave@bigdave.co.uk'
);

INSERT INTO customer VALUES (
    60,
    'Discount',
    'Dan',
    'Discount Disks',
    '1 Back Ally',
    'Luna 1',
    'Tranquility',
    'Moon',
    '58620',
    '600-321-6666',
    '666-321-7777',
    'dan@discountdansdiscountdisks.ru',
    5
);

INSERT INTO customer VALUES (
    61,
    'Honest',
    'Dave',
    'Discount Disks',
    '1 Back Ally',
    'Luna 1',
    'Tranquility',
    'Moon',
    '58620',
    '600-321-6666',
    '666-321-7777',
    'dan@discountdansdiscountdisks.ru',
    6
);

--2.4

UPDATE customer
SET
    firstname = 'Robert',
    lastname = 'Walter'
WHERE
    firstname = 'Aaron'
    AND lastname = 'Mitchell';

UPDATE artist
SET
    name = 'CCR'
WHERE
    name = 'Creedence Clearwater Revival';

--2.5

SELECT
    *
FROM
    invoice
WHERE
    billingaddress LIKE 'T%';

--2.6

SELECT
    *
FROM
    invoice
WHERE
    total BETWEEN 15 AND 50;

SELECT
    *
FROM
    employee
WHERE
    hiredate BETWEEN DATE '2003-06-01' AND DATE '2004-03-01';

--2.7

DELETE FROM invoiceline
WHERE
    invoiceid IN (
        SELECT
            invoiceid
        FROM
            invoice
        WHERE
            customerid IN (
                SELECT
                    customerid
                FROM
                    customer
                WHERE
                    firstname = 'Robert'
                    AND lastname = 'Walter'
            )
    );

DELETE FROM invoice
WHERE
    customerid IN (
        SELECT
            customerid
        FROM
            customer
        WHERE
            firstname = 'Robert'
            AND lastname = 'Walter'
    );

DELETE FROM customer
WHERE
    firstname = 'Robert'
    AND lastname = 'Walter';

--3.1

SELECT
    systimestamp
FROM
    dual;

SELECT
    length(name)
FROM
    mediatype;

--3.2

SELECT
    AVG(total)
FROM
    invoice;

SELECT
    *
FROM
    track
WHERE
    unitprice = (
        SELECT
            MAX(unitprice)
        FROM
            track
    );

--3.3

CREATE OR REPLACE FUNCTION avg_lineitem RETURN NUMBER AS
    average NUMBER;
BEGIN
    SELECT
        AVG(invoiceline.unitprice)
    INTO average
    FROM
        invoiceline;

    RETURN average;
END avg_lineitem;
/

SELECT
    avg_lineitem
FROM
    dual;

--3.4 --NOT DONE

DESC employee;

CREATE OR REPLACE FUNCTION after_1968 RETURN SYS_REFCURSOR IS
    employee_c SYS_REFCURSOR;
BEGIN
    OPEN employee_c FOR SELECT
                            *
                        FROM
                            employee
                        WHERE
                            birthdate >= TO_DATE('01-01-1968', 'DD-MM-YYYY');

    RETURN employee_c;
END;
/

SELECT
    after_1968
FROM
    dual;
--4.1

CREATE OR REPLACE PROCEDURE get_employee_names AS

    CURSOR output_e IS
    SELECT
        firstname,
        lastname
    FROM
        employee;

    o_first   VARCHAR2(100);
    o_last    VARCHAR2(100);
BEGIN
    OPEN output_e;
    LOOP
        FETCH output_e INTO
            o_first,
            o_last;
        EXIT WHEN output_e%notfound;
        dbms_output.put_line(o_first
                             || ' '
                             || o_last);
    END LOOP;

    CLOSE output_e;
END;
/
--test

BEGIN
    get_employee_names();
END;
/
--4.2
Create or replace procedure set_employee_personal(in_id in number,
oLASTNAME   in  VARCHAR2, 
oFIRSTNAME  in VARCHAR2,     
oBIRTHDATE     in      DATE  ,      
oADDRESS          in   VARCHAR2, 
oCITY        in        VARCHAR2, 
oSTATE       in        VARCHAR2, 
oCOUNTRY     in        VARCHAR2, 
oPOSTALCODE    in      VARCHAR2
) is
begin
    update employee set lastname = oLASTNAME, firstname = ofirstNAME, BIRTHDATE = oBIRTHDATE, address = oAddress, city = ocity, state = ostate, country = ocountry,  postalcode = opostalcode  where employee.employeeid = in_id;
    
end;
/
desc employee;


create or replace procedure get_manager (id_num in out number) is
begin
  select reportsto into id_num from employee where employeeid = id_num;
end;
/
desc customer;
--4.3
create or replace procedure get_customer (id_num in number, f_name out varchar2, l_name out varchar2, comp out varchar2) is
begin 
    select firstname, lastname, company into f_name, l_name, comp from customer where customerid = id_num;
end;
/


--5.0

CREATE OR REPLACE PROCEDURE delete_invoice (
    invoice_id IN NUMBER
) IS
BEGIN
    DELETE FROM invoiceline
    WHERE
        invoiceid = invoice_id;

    DELETE FROM invoice
    WHERE
        invoiceid = invoice_id;

    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE Add_customer ( 
customerid        in    NUMBER,
firstname         in    VARCHAR2, 
LASTNAME          in    VARCHAR2, 
COMPANY           in    VARCHAR2, 
ADDRESS           in    VARCHAR2, 
CITY              in    VARCHAR2, 
STATE             in    VARCHAR2, 
COUNTRY           in    VARCHAR2, 
POSTALCODE        in    VARCHAR2, 
PHONE             in    VARCHAR2, 
FAX               in    VARCHAR2, 
EMAIL             in    VARCHAR2, 
SUPPORTREPID      in    NUMBER) 
is
begin 
insert into customer values (customerid, firstname, lastname, company, address,
       city, state, country, postalcode, phone,
       fax, email, supportrepid);
       commit;
END;
/
desc customer;
--6.1

CREATE OR REPLACE TRIGGER new_employees AFTER
    INSERT ON employee
BEGIN
    dbms_output.put_line('Employees added');
END;
/

CREATE OR REPLACE TRIGGER new_album AFTER
    INSERT ON album
    FOR EACH ROW
BEGIN
    dbms_output.put_line('Album created');
END;
/

CREATE OR REPLACE TRIGGER customer_removal AFTER
    DELETE ON customer
    FOR EACH ROW
BEGIN
    dbms_output.put_line('Customer removed');
END;
/
--7.1

DESC invoice;

SELECT
    a.customerid,
    b.invoiceid
FROM
    customer   a
    INNER JOIN invoice    b ON a.customerid = b.customerid;
-- same as select customerid, invoiceid from invoice because invoice.customerid is NOT_NULL

--7.2

SELECT
    a.customerid,
    a.firstname,
    a.lastname,
    b.invoiceid,
    b.total
FROM
    customer   a
    FULL OUTER JOIN invoice    b ON a.customerid = b.customerid;

--7.3

SELECT
    b.name,
    a.title
FROM
    album    a
    RIGHT OUTER JOIN artist   b ON a.artistid = b.artistid;

--7,4

SELECT
    *
FROM
    album    a,
    artist   b
ORDER BY
    b.name ASC;

--7.5

DESC employee;

SELECT
    *
FROM
    employee   a
    FULL OUTER JOIN employee   b ON a.employeeid = b.reportsto;

ROLLBACK;