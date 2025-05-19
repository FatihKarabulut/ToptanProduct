
/*
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id = -1;

    @Column(name = "name")
    public String name;
    @Column(name = "added_by")
    public String addedBy;
    @Column(name = "stock")
    public int stock;
    @Column(name = "by_price")
    public BigDecimal byPrice;
    @Column(name = "sell_price")
    public BigDecimal sellPrice;
    @Column(name = "date_time")
    public LocalDateTime datetime;
 */
/*
 create table product(
    id bigserial primary key,
    name varchar(500) not null,
    added_by_name varchar(250) not null,
    stock int check ( stock >= 0) not null,
    sell_price numeric(10,2) not null,
    by_price numeric(10,2) not null,
    date_time timestamp default CURRENT_TIMESTAMP not null

)
 */