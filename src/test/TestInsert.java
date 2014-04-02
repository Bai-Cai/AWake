package test;

import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.baicai.awake.sql.SQLUpdate;

public class TestInsert extends TestBase {

	@Before
	public void setUp() throws Exception {
		setUpDirectConnection();
	}

	@After
	public void tearDown() throws Exception {
		closeSingle();
	}

	@Test
	public void test() throws SQLException {

//		SQLUpdate update = new SQLUpdate();
//		Map<String, Object> map = new TreeMap<>();
//		map.put("num_tagged", 6);
//		map.put("content", "testt222");
//		update.insert("bw_tag", map);
//		
//		PreparedStatement ps = update.build(getSingle());
//		
//		System.err.println(ps.toString());
//		
//		ps.execute();
		
		new SQLUpdate(getSingle()).insertInto("bw_tag")
				.put("num_tagged", 19)
				.put("content", "new put()")
				.execute();
	}

}










