import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class ChampionTest {

    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    @Test
    public void givenCollectionWhenEmptyCorrect()
    {
        List<String> emptyList = new ArrayList<String>();
        assertThat(emptyList, empty()); //emptyList가 empty()인지 체크
    }

    @Test
    public void notNullCheck(){
        String lck = "LCK";
        assertThat(lck, notNullValue()); // lck가 notNullValue인지 체크
    }

    @Test
    public void 확인테스트() {
        String sampleString = "Player Focus";
        String startString = "Player";
        String endString = "Focus";
        assertThat(sampleString, anyOf(startsWith(startString), containsString(endString))); //anyOf(여러가지중 아무거나)  satrtWith(시작단어) containString(들어있는가)
        assertThat(sampleString, is(endsWith(endString))); // 스트링끝이 endString으로 되어있는지 확인
    }

    @Test
    public void 부동소수점체크()
    {
        assertThat(3.14, closeTo(3,0.2)); //3부터 3.2까지 체크,

    }

    @Test
    public void shouldNotErrorGetReference()
    {
        assertThat(championList.get(2), anything()); //값을 가져올수만있으면, 성공
        //언제쓰냐? 랜덤값 가져오는데 랜덤값이 뭔지 모르잖아요. 로직이 제대로 돌아가는지 확인.
    }

    @Test
    public void shouldChampionCountFive()
    {
        assertThat(championList.size(), is(5)); //사이즈값이 5면 테스트성공
        assertThat(championList, hasSize(5)); //같은의미 다른형식
    }

    @Test
    public void 서폿챔피언은타릭이여야만한다()
    {
        Champion supportChamp = new Champion( "타릭","바텀");
        assertThat("타릭",is(supportChamp.getName()));
        assertThat("타릭",is(equalTo(supportChamp.getName())));
        assertThat("타릭",equalTo(supportChamp.getName()));
    }

    @Test
    public void shouldHasPropertyPosition()
    {
        //0번째 인덱스의 객체 속성이 position이라는걸 가지고있는지, 탑이라는값을 가지는지
        assertThat(championList.get(0), hasProperty("position"));
        assertThat(championList.get(0), hasProperty("position",equalTo("탑")));

    }

    @Test
    public void shouldHaveSomeChampName()
    {
        List<String> championNames = Arrays.asList("루시안","애쉬","렉사이","갈리오","소라카");
        assertThat(championNames.get(0), hasToString("루시안"));
        //첫번째 챔피언 값이 루시안이면, 테스트성공
    }
    @Test
    public void shouldTopChampionIsDarius()
    {
        Optional<Champion> filterdChampion = championList.stream()
                .filter(c -> c.getPosition().equals("탑"))
                .findFirst();
        String champName = filterdChampion.get().getName();
        assertTrue(champName.equals("다리우스"));
        assertThat("다리우스", is(champName));

    }

}