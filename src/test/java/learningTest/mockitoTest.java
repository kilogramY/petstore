package learningTest;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.mock;

import java.util.List;

import static org.mockito.BDDMockito.*;

public class mockitoTest {

	@Test
	public void test() {
		List<String> list = mock(List.class);
		
		given(list.get(0)).willReturn("Hi");
		
		list.add("Hello");
		list.add("Hello");
		list.add("Hello2");
		
		//verify(list).add("");
		verify(list).add("Hello2");
		verify(list,never()).add("Hello3");
	}

}
