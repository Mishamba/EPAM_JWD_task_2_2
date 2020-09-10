package mishamba.day2.controller.impl.dataprovider;

import com.mishamba.day2.model.CustomText;
import com.mishamba.day2.model.Part;
import com.mishamba.day2.model.Sentence;
import com.mishamba.day2.util.factory.impl.PartsFactoryImpl;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;

public class TextProvider {
    @DataProvider(name = "text provider")
    public Object[][] provideText() {
        ArrayList<Part> firstPart = new ArrayList<>();
        firstPart.add(PartsFactoryImpl.getInstance().createSentencePart("this"));
        firstPart.add(PartsFactoryImpl.getInstance().createSentencePart("is"));
        firstPart.add(PartsFactoryImpl.getInstance().createSentencePart("my"));
        firstPart.add(PartsFactoryImpl.getInstance().createSentencePart("text"));
        firstPart.add(PartsFactoryImpl.getInstance().createSentencePart("."));

        ArrayList<Part> secondPart = new ArrayList<>();
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("this"));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("is"));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("a"));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("cool"));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("text"));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart(","));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("so"));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("i"));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("like"));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("this"));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("this"));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("one"));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("very"));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("much"));
        secondPart.add(PartsFactoryImpl.getInstance().createSentencePart("."));

        ArrayList<Part> thirdPart = new ArrayList<>();
        thirdPart.add(PartsFactoryImpl.getInstance().createSentencePart("i'l"));
        thirdPart.add(PartsFactoryImpl.getInstance().createSentencePart("do"));
        thirdPart.add(PartsFactoryImpl.getInstance().createSentencePart("this"));
        thirdPart.add(PartsFactoryImpl.getInstance().createSentencePart("thi-ng"));
        thirdPart.add(PartsFactoryImpl.getInstance().createSentencePart("."));

        ArrayList<Sentence> sentences = new ArrayList<>();
        sentences.add(new Sentence(firstPart));
        sentences.add(new Sentence(secondPart));
        sentences.add(new Sentence(thirdPart));

        return new Object[][] {
                {" this is my text. this is a cool text, so i like this one" +
                        " very much. i'l do this thi-ng.",
                new CustomText(sentences)}
        };
    }
}
