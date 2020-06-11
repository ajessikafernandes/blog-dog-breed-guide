package br.com.blogdogbreedguide.utils;

import br.com.blogdogbreedguide.entity.Post;
import br.com.blogdogbreedguide.repository.PostRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    PostRepository repository;

    public void savePosts() {

        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        post1.setAuthor("Jéssika Fernandes");
        post1.setDate(LocalDate.now());
        post1.setTitle("Tudo Sobre o seu: Bulldog Francês");
        post1.setText("Também conhecido como “Frenchie”, acredita-se que o buldogue francês teve sua origem em três países: Inglaterra, França e Estados Unidos. Os criadores da raça defendem que a Inglaterra é responsável pela origem no antigo Buldogue. A França ajudou a desvincular os Buldogues Franceses dos Buldogues ingleses e os EUA foram os responsáveis por trazerem as orelhinhas pra cima, característica muito conhecida desses pets.");

        Post post2 = new Post();
        post2.setAuthor("Jéssika Fernandes");
        post2.setDate(LocalDate.now());
        post2.setTitle("Tudo Sobre o seu: Golden Retriever");
        post2.setText("De origem britânica, conhecido por ser muito dócil e companheiro, o Golden Retriever é considerado por muitos o “cão dos sonhos”. Bastante inteligente, pronto para aprender truques e muitas vezes usados como cães-guia, o Golden é um cachorro ativo e que gosta de ajudar e agradar a todos (inclusive aqueles que não conhece tão bem). Adora truques e precisa de muita atenção e de tempo disponível para gastar sua energia. Ele também é um ótimo nadador e o favorito de várias famílias, algo que fez com que a sua popularidade ficasse bastante alta nas últimas décadas aqui no Brasil e no mundo.");

        postList.add(post1);
        postList.add(post2);

        for (Post post : postList) {
            Post postSaved = repository.save(post);
            System.out.println(postSaved.getId());
        }
    }

}
