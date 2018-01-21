package util.generator;

import net.mindview.util.Generator;
import util.StoryCharacters.*;

import java.util.Iterator;
import java.util.Random;

public class CharactersGenerator implements
        Generator<StoryCharacter>, Iterable<StoryCharacter> {
    private Class[] types = {Anlushan.class, DongZhuo.class, HeShen.class,
            WangJingwei.class, WeiZhongxian.class, HuangFeihong.class, QianXuesen.class,
            QuYuan.class, XuWenqiang.class, YueFei.class};
    private int size = 0;
    private static Random rand = new Random(47);

    public CharactersGenerator() {
    }

    public CharactersGenerator(int n) {
        size = n;
    }

    public StoryCharacter next() {
        try {
            return (StoryCharacter) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<StoryCharacter> iterator() {
        return new Iterator<StoryCharacter>() {
            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public StoryCharacter next() {
                size--;
                return CharactersGenerator.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
