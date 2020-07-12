CREATE KEYSPACE IF NOT EXISTS wootag WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;
CREATE TABLE IF NOT EXISTS wootag.skus (
    skuId text,
    productName text,
    storeId text,
    storeName text,
    cart text,
    city text,
    state text,
    country text,
    stocks int,
    price decimal,
    currency text,
    PRIMARY KEY (skuId, storeId)
);

instance   vCPU	ECU	Memory  Storage(GB)          Linux/UNIX Usage    DB
m4.2xlarge	8	26	32 GiB	EBS Only	         $0.50 per Hour      small to medium size NoSQL DB
i3.2xlarge	8	31	61 GiB	1 x 1900 NVMe SSD	 $0.748 per Hour     large scale NoSQL