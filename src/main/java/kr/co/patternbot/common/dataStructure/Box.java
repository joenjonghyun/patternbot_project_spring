package kr.co.patternbot.common.dataStructure;

import kr.co.patternbot.users.domains.User;
import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Data
@Lazy //레이지(게으른) 로딩 이라고 함 Lazy Loading 디비가 필요없다는 뜻 내가 호출 할 때 인스턴스를 생성한다는 것.
//컴포넌트를 사용하는 것은 순수자바를 쓰겠다는 의미, 라우터도 미들웨어도 안 쓴다는 의미? 레파지토리는 당연하고.
//제네릭은 하나만 만들어서 넣으면 됨 안에있는 내용물만 생각하다는 거 같음. 사용 이유는 메모리를 극한으로 아끼자는 의미. 재활용성이 좋음
//추가검색이 필요할땐 맵을 사용, 미들웨어역할을한다고생각하면되는게리스트. 이 두가지만 사용할건데 언제 어떻게 사용해야 하는건지 알아보셈

public class Box<K, V> {
    private HashMap<K, V> map;
    public Box() {
        this.map = new HashMap<>();
    }
    //반드시 구현할 공통기능
    public void put(K k , V v){map.put(k , v);}
    public void replace(K k , V v){map.replace(k ,v);}
    public void remove(K k , V v){map.remove(k , v);}
    public List<V> values(){return map.values().stream().collect(Collectors.toList());}
    public V get(String id){return map.get(id);}
    public int size(){return map.size();}
    public void clear(){map.clear();}
    // 테이블 행 목록 요청시
    public List<V> findAllList() {
        List<V> ls = new ArrayList<>();
        for (Map.Entry<K, V> e: map.entrySet()) {
            ls.add((V) e.getValue());
        }
        return ls;
    }
    //테이블 키값 목록 요청시
    public List<V> findAllUserKeyList() {
        List<V> ls = new ArrayList<>();
        for (Map.Entry<K, V> e: map.entrySet()) {
            ls.add((V) e.getValue());
        }
        return ls;
    }
    //유저네임으로 검색된 회원 목록요청시 (필터가 필요없는 리액트로 던지는 경우)
    public List<User> findByUserName(String name) {
        List<User> ls = new ArrayList<>();
        for (User v : ls) {if (name.equals(v.getUsername())) {ls.add(v);}}
        return ls;
    }
    //유저네임으로 검색된 회원 목록요청시(추가 필터를 통해 더 결과값이 필요한 경우)
    public Map<String, User> mapFindByUserName(String name){
        Map<String, User> map = new HashMap<>();
        for (Map.Entry<String, User> e: map.entrySet()){
            if (name.equals(e.getValue().getUsername())) map.put(e.getKey(),e.getValue());
        }
        return map;
    }
}