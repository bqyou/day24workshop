package sg.nus.edu.iss.day24workshop.repo;

public class Queries {

        public static final String INSERT_ORDER = """
                        insert into orders (order_id, customer_name, ship_address, notes, tax)
                        values (?, ?, ?, ?, ?)
                        """;

        public static final String INSERT_LINEITEM = """
                        insert into line_item(product, quantity, order_id, unit_price, discount)
                        values (?, ? ,? ,?, ?)
                        """;

        public static final String SQL_COUNT_PO_TABLE_PRED_ORDERID = """
                        select count(*) from line_item where order_id = ?
                            """;

        public static final String SQL_COUNT_LINEITEM_TABLE_PRED_ORDERID = """
                        select count(*) from line_item where order_id = ?
                         """;

}
