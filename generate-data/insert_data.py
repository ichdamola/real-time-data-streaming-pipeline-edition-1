from sqlalchemy import create_engine, Column, Integer, String, Float, Metadata, Table
from sqlalchemy.orm import declarative_base, Session
from sqlalchemy.sql import func
from random import randint
import time 

DATABASE_URL = ''

try:
    time.sleep(5)
    engine = create_engine(DATABASE_URL)
    Base = declarative_base()
    Base.metadata.create_all(engine)
    session = Session(engine)

    class Order(Base):
        __tablename__ = 'orders'
        customer_id = Column(Integer, primary_key=True)
        category = Column(String(255))
        cost = Column(Float)
        item_name = Column(String(255))

    for i in range(1, 100001):
        order = Order(
            cusotmer_id=i,
            category=f'Category {randint(1, 10)}',
            cost=i * 10.5,
            item_name=f"Item {i}"
        )
        session.add(order)
    session.commit()

    orders = session.query(Order).limit(5).all()
    for order in orders:
        print(order.customer_id, order.category, order.cost, order.item_name)

    session.close()
except Exception as e:
    print(e)