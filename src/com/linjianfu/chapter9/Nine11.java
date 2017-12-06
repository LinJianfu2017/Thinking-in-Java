package com.linjianfu.chapter9;

interface Processor {
    String name();

    Object process(Object input);
}

/**
 * 调度中心
 */
class Apply {
    public static void processer(Processor p, Object o) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(o));

    }
}

/**
 * 对string中每一对字符互换位置,主处理程序。
 */
class Smixer {
    public String mixerString(String s) {
        char[] c = new char[s.length()];
        if (s.length() % 2 == 0) {
            for (int i = 0; i < s.length(); i += 2) {
                c[i] = s.charAt(i + 1);
                c[i + 1] = s.charAt(i);
            }
        } else {
            for (int i = 0; i < s.length() - 1; i += 2) {
                c[i] = s.charAt(i + 1);
                c[i + 1] = s.charAt(i);
            }
            c[s.length() - 1] = s.charAt(s.length() - 1);
        }

        return new String(c);
    }
}

/**
 * 适配器，负责对接
 */
class SmixerAdapter implements Processor {
    Smixer smixer = new Smixer();

    SmixerAdapter(Smixer smixer) {
        this.smixer = smixer;
    }

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    public String process(Object input) {
        return smixer.mixerString((String) input);
    }
}

/****************************************/
class SmixerProcessor {
    public static void main(String[] args) {
        String s = "linjianfu";
        Apply.processer(new SmixerAdapter(new Smixer()), s);
    }
}

/**
 * 《用户界面》
 */
public class Nine11 {
    public static void main(String[] args) {
        SmixerProcessor.main(args);

    }

}
