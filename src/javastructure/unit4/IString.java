package javastructure.unit4;

public interface IString {
    void clear();

    boolean isEmpty();

    int length();

    char charAt(int index) throws Exception;

    IString substring(int begin, int end) throws Exception;

    IString insert(int offset, IString str) throws Exception;

    IString delete(int begin, int end) throws Exception;

    IString concat(IString str);

    int compareTo(IString str);

    int indexOf(IString str, int begin);
}
