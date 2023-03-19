package nx.peter.java.util.extract;

import nx.peter.java.util.Util;
import nx.peter.java.util.data.DataManager;
import nx.peter.java.util.data.Texts;

import java.util.ArrayList;
import java.util.List;

public interface Extractor {
    <W> DataList extract(W what);

    <W> DataList extractFrom(W what, int index);

    <W> DataList extractBefore(W what, int index);

    DataList extractNewLines();

    DataList extractNewLinesFrom(int index);

    DataList extractNewLinesBefore(int index);

    DataList extractTabs();

    DataList extractTabsAfter(int index);

    DataList extractTabsBefore(int index);


    class DataList extends Util.Array<DataInfo> {
        public DataList(List<DataInfo> items) {
            super(items);
        }

        public boolean contains(CharSequence content) {
            return findDataByContent(content) != null;
        }

        public DataInfo findDataByIndex(int index) {
            for (DataInfo info : items)
                if (info.getIndex() == index) return info;
            return null;
        }

        public DataInfo findDataByContent(CharSequence content) {
            if (content != null)
                for (DataInfo info : items)
                    if (info.getContent().contentEquals(content)) return info;
            return null;
        }

    }

    interface DataInfo {
        String getSource();

        String getContent();

        int getLength();

        int getIndex();

        boolean isEmpty();

        boolean isNotEmpty();

        boolean isAlphabetOnly();

        boolean isNumberOnly();

        boolean isAlphabet();

        boolean isNumber();

        boolean equals(DataInfo info);
    }

    class Builder {
        Texts source;

        public Builder() {
            this("");
        }

        public Builder(CharSequence source) {
            setSource(source);
        }

        public Builder setSource(CharSequence source) {
            this.source = new Texts(source != null ? source : "");
            return this;
        }

        public Extractor build() {
            return new IExtractor(source.get());
        }


        protected static class IDataInfo implements DataInfo {
            protected Texts source, content;
            protected int index;

            public IDataInfo(Texts source, Object content, int index) {
                this.source = source;
                this.index = index;
                this.content = new Texts(content.toString());
            }

            @Override
            public String getSource() {
                return source.get();
            }

            @Override
            public String getContent() {
                return new Texts(content.get())
                        .replaceAll("\n", "_NEWLINE_")
                        .replaceAll("\t", "_TAB_")
                        .get();
            }

            @Override
            public int getLength() {
                return content.length();
            }

            @Override
            public int getIndex() {
                return index;
            }

            @Override
            public boolean isEmpty() {
                return content.isEmpty();
            }

            @Override
            public boolean isNotEmpty() {
                return content.isNotEmpty();
            }

            @Override
            public boolean isAlphabetOnly() {
                for (char c : content.toCharArray())
                    if (!DataManager.isAlphabet(c)) return false;
                return true;
            }

            @Override
            public boolean isNumberOnly() {
                return DataManager.isNumberOnly(content.get());
            }

            @Override
            public boolean isAlphabet() {
                return content.isAlphabet();
            }

            @Override
            public boolean isNumber() {
                return content.isNumber();
            }

            @Override
            public boolean equals(DataInfo info) {
                return info != null && info.getContent().contentEquals(content.get()) && info.getIndex() == index;
            }

            @Override
            public String toString() {
                return "{\n\t" +
                        "\"content\": \"" + getContent() +
                        "\",\n\t\"index\": " + index +
                        "\n}";
            }
        }

        protected static class IExtractor implements Extractor {
            protected Texts source;

            public IExtractor(CharSequence source) {
                this.source = new Texts(source != null ? source.toString() : "");
            }

            @Override
            public <W> DataList extract(W what) {
                return extract(source.get(), what, 0, false);
            }

            protected <W> DataList extract(String src, W what, int from, boolean before) {
                List<DataInfo> dataInfo = new ArrayList<>();
                if (what != null && src != null) {
                    Texts data = new Texts(src);
                    int index = 0;
                    int count = data.wordCount(what.toString());
                    /*for (int time = 0; time < count; time++) {
                        System.out.println("Index Before: " + index);
                        index = data.indexOf(what.toString(), index);
                        System.out.println("Index " + index);
                        if (index <= -1) break;
                        dataInfo.add(new IDataInfo(data, what, index));
                        index++;
                    }*/
                    while (count > 0 && data.subLetters(index).contains(what.toString())) {
                        index = data.indexOf(what.toString(), index);
                        if (index <= -1) break;
                        dataInfo.add(new IDataInfo(data, what, index + (before ? 0 : from)));
                        index++;
                        count--;
                    }
                }
                return new DataList(dataInfo);
            }

            @Override
            public <W> DataList extractFrom(W what, int index) {
                return extract(source.substring(index), what, index, false);
            }

            @Override
            public <W> DataList extractBefore(W what, int index) {
                return extract(source.substring(0, index), what, index, true);
            }

            @Override
            public DataList extractNewLines() {
                return extractFrom("\n", 0);
            }

            @Override
            public DataList extractNewLinesFrom(int index) {
                return extractFrom("\n", index);
            }

            @Override
            public DataList extractNewLinesBefore(int index) {
                return extractBefore("\n", index);
            }

            @Override
            public DataList extractTabs() {
                return extractFrom("\t", 0);
            }

            @Override
            public DataList extractTabsAfter(int index) {
                return extractFrom("\t", index);
            }

            @Override
            public DataList extractTabsBefore(int index) {
                return extractBefore("\t", index);
            }
        }
    }

}
