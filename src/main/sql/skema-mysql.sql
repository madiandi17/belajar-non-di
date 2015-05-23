create table produk (
    id integer auto_increment,
    kode varchar(15) not null,
    nama varchar(45) not null,
    harga decimal(8,2) not null,
    primary key(id)
)Engine=InnoDB;

create table user (
    id integer auto_increment,
    firstName varchar(45) not null,
    lastName varchar(45) not null,
    email varchar(45)not null unique,
    primary key(id)
)Engine=InnoDB;

-- test create data
Produk p = new Produk();
p.setKode("p-001");
p.setNama("Produk 001");
p.setHarga(new BigDecimal(10000.00));
        
ProdukDao pd = new ProdukDao();
pd.create(p);

-- test read data
Produk p = new Produk();
ProdukDao pd = new ProdukDao();
pd.read(p);

-- test carById data produk
ProdukDao pd = new ProdukDao();
Produk p = pd.cariById(1);

-- test cariByNama data produk
ProdukDao pd = new ProdukDao();
Produk p = pd.cariByNama("p-002");

-- test update data produk
ProdukDao pd = new ProdukDao();
Produk p = new Produk();
p.setKode("P-001");
p.setNama("P-001");
p.setHarga(new BigDecimal(100000.00));
p.setId(1);
pd.update(p);

-- test delete data produk
ProdukDao pd = new ProdukDao();
Produk p = new Produk();   
p.setId(1);
pd.delete(p);

-- test create data user
UserDao userDao = new UserDao();
User user = new User();
user.setFirstName("madi");
user.setLastName("andi");
user.setEmail("madiandi@yahoo.com");
userDao.create(user);
        
-- test read data user
UserDao userDao = new UserDao();
User user = new User();
userDao.read(user);

-- test cariById data user
UserDao userDao = new UserDao();
User user = userDao.cariById(1);

-- test cariByEmail data user
UserDao userDao = new UserDao();
User user = userDao.cariByEmail("madiandi@yahoo.com");

-- test update data user
UserDao userDao = new UserDao();
User user = new User();
user.setFirstName("Andi");
user.setLastName("Gosling");
user.setEmail("andigosling@gmail.com");
user.setId(1);
        
userDao.update(user);

-- test delete data user
UserDao userDao = new UserDao();
User user = new User();
user.setId(1);
        
userDao.delete(user);
