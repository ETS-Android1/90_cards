package com.example.a90_cards;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a90_cards.screens.FinalScreen;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Ninety_cards extends AppCompatActivity {

    public enum Language {ITALIAN, ENGLISH}

    private static Language chosen_language = Language.ENGLISH;

    private Deck cards = new Deck();
    private List<Card> card_list = new ArrayList();

    private TextView card_text;
    private TextView message_number;
    private TextView card_title;
    private TextView small_title;
    private TextView timer_time_left;
    private TextView timer_title_left;
    private TextView timer_time_right;
    private TextView timer_title_right;

    private ImageView card_icon;
    private Card playing_card;

    List<TextView> timers = new ArrayList<>();

    private int time = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Card.count = 0;

        card_text = findViewById(R.id.card_question);
        message_number = findViewById(R.id.card_number);
        card_title = findViewById(R.id.title_text);
        card_icon = findViewById(R.id.card_icon_Image);
        small_title = findViewById(R.id.small_title);
        timer_time_left = findViewById(R.id.timer_time_left);
        timer_title_left = findViewById(R.id.timer_title_left);
        timer_time_right = findViewById(R.id.timer_time_right);
        timer_title_right = findViewById(R.id.timer_title_right);

        timers.add(timer_title_left);
        timers.add(timer_title_right);

        card_text.setMovementMethod(new ScrollingMovementMethod());


        card_icon.setVisibility(View.GONE);

        switch (chosen_language) {
            case ITALIAN:
                /*
                card_list.add(new Card("Lingue straniere", "Parli per 5 minuti una lingua che non sia la tua lingua madre. Ogni volta che parli nella tua lingua, bevi 2 sorsi.", time));
                //card_list.add(new Card("Modi di dire", "Parli per 5 minuti solo tramite modi di dire. Se vieni beccato a non farlo, bevi 2 sorsi.", 300));
                //card_list.add(new Card("Ave Maria", "Recita le prime due parole dell'Ave Maria. Il giocatore alla tua destra prosegue con altre due parole. Chi sbaglia dedica 2 sorsi a Maria. Se nessuno sbaglia, tutti bevono 1 sorso per il bambin Gesù."));
                //card_list.add(new Card("Il Vietnam non si dimentica", "La Guerra è appena iniziata. Scegli 2 soldati da portare con te. Per le prossime 5 carte, ognuno di voi beve 1 sorso extra."));
                card_list.add(new Card("TIK TOK", "Crea una mossa di danza. Il giocatore alla tua destra ti imita e aggiunge una sua mossa. Si continua fino a quando il giro è completo. Il primo a sbagliare beve 2 sorsi."));
                card_list.add(new Card("X Factor", "Chi pesca questa carta deve esibirsi in una performance canora (in singolo o in gruppo). Se la performance è soddisfacente, tutti bevono 2 sorsi."));
                card_list.add(new Card("Cascata Time", "Tutti iniziano a bere. Quando la persona alla tua sinistra smette di bere puoi smettere pure tu (o continuare). Bisogna completare un giro. Si comincia da chi ha pescato."));
                card_list.add(new Card("Cascata Time", "Tutti iniziano a bere. Quando la persona alla tua sinistra smette di bere puoi smettere pure tu (o continuare). Bisogna completare un giro. Si comincia da chi ha pescato."));
                card_list.add(new Card("Focus Junior - Storia", "A turno ognuno cita un personaggio storico del XX secolo. Chi non ne trova più beve 2 sorsi."));
                card_list.add(new Card("Focus Junior - Letteratura", "A turno ognuno cita un personaggio della letteratura italiana. Chi non ne trova più beve 2 sorsi."));
                //card_list.add(new Card("Prurito al naso", "Chi pesca questa carta ha la possibilità per 4 turni di toccarsi il naso. L'ultimo che lo imita beve 2 sorsi. Il gesto del tocco deve essere continuo, affinché tutti possano notarlo."));
                //card_list.add(new Card("Avanti un altro", "Chi pesca questa carta sceglie un concorrente. In 45 secondi deve dare la risposta sbagliata alle 6 domande che seguiranno. Se sbaglia, ricomincia da capo. Se riesce nell'impresa, il lettore delle domande beve 3 sorsi, o il contrario."));
                card_list.add(new Card("L'imitatore", "Per 5 minuti puoi parlare solo con una \"vocina\". Bevi 2 sorsi per ogni volta che non lo fai", time));
                //card_list.add(new Card("Prova a chiedermelo", "Scegli il tuo compagno. In 1 minuto di tempo, devi fargli indovinare le 5 parole che seguiranno, ovviamente senza usare le parole stesse. Se vincete, gli altri fanno tre sorsi, altrimenti li fate voi (a testa)."));
                card_list.add(new Card("Whisper challenge", "Chi pesca la carta sceglie un compagno. Il compagno ascolta musica con il volume al massimo, mentre tu cerchi di fargli indovinare una frase a scelta. Se entro 1 minuto il compagno la indovina, distribuite 4 sorsi, altrimenti ne bevete 2 a testa."));
                card_list.add(new Card("Indovina chi", "Scegli un personaggio famoso. Gli altri a turno fanno una domanda, alla quale si può rispondere con SÌ o NO. Se la risposta è NO, chi ha posto la domanda beve 1 sorso. Se entro 2 minuti e mezzo il personaggio viene indovinato, beve 3 sorsi chi ha pescato la carta."));
                //card_list.add(new Card("Would you rather...", "Far diventare il tuo soprannome Hitler o mangiare solamente tofu? La minoranza beve 1 sorso."));
                card_list.add(new Card("Città europee dalla A alla Z", "Nomina una città europea. Il giocatore alla tua destra nomina una città che inizia con la l'ultima lettera della tua città. Si compiono 2 giri. Chi sbaglia beve 2 sorsi. Massimo 5 secondi per ogni risposta."));
                //card_list.add(new Card("È per caso tempo di film?", "Chi pesca questa carta può scegliere tra 3 parole: Covid, piede o sbocchino. Si fa un giro. Ognuno deve sostituire una parola del titolo di un film con la parola scelta. Chi crea il titolo migliore può distribuire 4 sorsi."));
                //card_list.add(new Card("Oh, ma ti ricordi...?", "C'è nostalgia nell'aria. Scegli qualcuno fra i giocatori e racconta il ricordo più ignorante che hai con lui/lei (se non ne trovi, cerca nel tuo cassetto dell'imbarazzo e racconta una tua avventura imbarazzante). A fine racconto tutti fanno 3 sorsi all'amicizia."));
                card_list.add(new Card("È destino fraté", "Scegli un numero da 1 a 31. \n\n\n\n\nIl giocatore alla tua destra sceglie un numero da 1 a 12. \n\n\n\n\nChi ha il compleanno prima della data scelta beve 2 sorsi. Se la data è il compleanno di qualcuno, shottino come regalo. E tanti auguri."));
                card_list.add(new Card("BUFALA!", "Da ora si beve con la mano debole. Se vedete qualcuno sbagliare mano, urlategli BUFALA! per farglielo bere a fiato."));
                card_list.add(new Card("Bottle Flip Challenge!", "Hai tre tentativi di lancio. Il numero di flip riusciti corrisponde al numero di sorsi distribuiti.\n1 bottle flip = 2 sorsi.\n2 bottle flip = 5 sorsi \n3 bottle flip = 10 sorsi"));
                //card_list.add(new Card("Frasi versatili", "Chi pesca inizia dicendo una frase che si può usare sia in ambito sportivo che a letto. Chi non ne sa più o dice un \"no sense\", beve 2 sorsi."));
                //card_list.add(new Card("Piccoli brividi", "A turno, iniziando da chi ha pescato, citare una paura. Chi condivide quella paura beve 1 sorso."));
                card_list.add(new Card("Non ho mai", "Parte da te un giro di \"non ho mai\". Chi ha già fatto il \"non ho mai\" citato, beve 1 sorso."));
                //card_list.add(new Card("Supereroi", "A turno, ognuno dice un superpotere che vorrebbe avere. Chi pensa che il superpotere spacchi, beve 2 sorsi."));
                //card_list.add(new Card("In quale epoca storica avresti voluto vivere?", "\"Vorrei aver vissuto nel 1942, per vivere la seconda guerra mondiale\". Così rispose Miss Italia 2015. E tu? Si fa il giro e se ti piace la risposta di qualcun'altro, bevi 1 sorso."));
                //card_list.add(new Card("A cena con...", "Con che personaggio famoso ti piacerebbe andare a cena? A giro ognuno dice la sua. Se condividi la scelta di qualcun'altro, bevi 1 sorso."));
                card_list.add(new Card("Mix letale", "Puoi scegliere una vittima che dovrà sorbirsi un mix preparato da te (massimo 2 bevande). Se lo sfidante rifiuta il mix, deve comunque farsi uno shot semplice, scelto dal bartender. Se lo sfidante beve il mix, il bartender beve uno shot semplice, scelto dallo sfidante. Se una persona esterna inetrviene e beve il mix, anche il bartender lo dovrà bere."));
                card_list.add(new Card("Shot Time", "Mi spiace soci, è ora di uno shottino. Scegli 2 compagni che berranno con te."));
                card_list.add(new Card("Shot Time", "Mi spiace soci, è ora di uno shottino. Scegli 2 compagni che berranno con te."));
                //card_list.add(new Card("Non è mai troppo tardi", "Quando eri bambino, cosa volevi diventare in futuro, e perché proprio un astronauta? A turno, ognuno dice la sua e alla fine tutti bevono 2 sorsi, in onore dell'infanzia."));
                card_list.add(new Card("Il primo che ride...", "Scegli il tuo avversario. Testa a testa, niente contatto fisico, niente comunicazione, chi ride beve 3 sorsi. Voglio un incontro pulito."));
                card_list.add(new Card("Il primo che ride...", "Scegli il tuo avversario. Testa a testa, niente contatto fisico, niente comunicazione, chi ride beve 3 sorsi. Voglio un incontro pulito."));
                //card_list.add(new Card("Il senso della vita", "Se devi racchiudere il senso della vita in tre parole, quali sceglieresti? A turno ognuno nomina le sue 3 parole e le spiega. Chi è d'accordo con ciò che viene detto, beve 1 sorso"));
                //card_list.add(new Card("La scatola dei ricordi", "Cosa diresti al te stesso del passato? A ruota libera ognuno dice la sua. Ognuno beve 1 sorso, salute alla vita!"));
                //card_list.add(new Card("Scacciapensieri", "Il tuo cartone animato preferito da bambino? A turno, ognuno dice il proprio. Ad ogni cartone citato, chi lo guardava beve 1 sorso."));
                //card_list.add(new Card("Freud in", "Svela una tua fantasia sessuale. Scegli altri due fortunelli che dovranno svelare la loro. Le persone che non vengono scelte invece, si bevono 2 sorsi."));
                card_list.add(new Card("Lotta fra i sessi", "Ci sono più ragazze o ragazzi nel gruppo? Beve la minoranza. In caso di pareggio, bevono tutti."));
                //card_list.add(new Card("Ouch, questa faceva male!", "A turno, ognuno dice una cosa che fa davvero male. Chi è d'accordo, beve 1 sorso."));
                card_list.add(new Card("Medusa", "Per 5 minuti, se guardi qualcuno e lui/lei ricambia, quella persona beve 1 sorso.", time));
                //card_list.add(new Card("Vacanza da sogno", "Dove andresti per la tua vacanza da sogno? A giro, ognuno racconta la propria. Se la vacanza di qualcun'altro ti ispira, bevi 1 sorso."));
                card_list.add(new Card("E tu per chi stai?", "Coop, Migros, Denner, Aldi, Esselunga, ..., da che parte state? Le minoranze sono sempre discriminate in questo gioco, perciò stavolta beve la maggioranza. In caso di pareggio, le scelte pareggianti bevono."));
                //card_list.add(new Card("Metodi di approccio", "Meglio un approccio social o di persona? La minoranza beve."));
                //card_list.add(new Card("Money!", "Hai 10'000 franchi da spendere in una giornata. Come li spenderesti? Scegli altre 2 perone che esporranno le proprie idee. Alla fine, tutti fanno 2 sorsi in onore dei paguri."));
                card_list.add(new Card("Lo faresti per 1000 franchi?", "Beve la minoranza per ogni domanda.\n-Farti un tatuaggio scelto da un amico/a.\n-Partecipare una settimana a Pomeriggio Cinque come spettatore.\n-Mangiare vegano per 3 mesi e 4 giorni."));
                card_list.add(new Card("Facciamo dell'ironia", "Pro black humour o \"su certi argomenti non bisognerebbe scherzare!\"? Beve la minoranza. In caso di pareggio, tutti brindano."));
                //card_list.add(new Card("Festival del cinema di Cannes", "A turno ognuno dice qual è il suo film preferito. Chi ha visto il film beve 1 sorso."));
                //card_list.add(new Card("The greatest hit", "A turno ognuno nomina la canzone che meglio descrive la propria vita. Un brindisi ai cugini di campagna."));
                //card_list.add(new Card("Teletrasporto", "Puoi usare il teletrasporto e trasferirti ovunque tu voglia, con chi preferisci. Ognuno dice la sua. Alzate i calici per tutti gli Abra nel mondo e bevete tutti 2 sorsi."));
                //card_list.add(new Card("Ué vegio", "Per 5 minuti tu sarai il vegio/la vegia. Dovrai imitare nelle movenze e nel parlato un végett. Se ti dimentichi di farlo, bevi 1 sorso.", 300));
                card_list.add(new Card("Tutte le persone...", "...più giovani di chi ha pescato, bevono 2 sorsi."));
                card_list.add(new Card("Tutte le persone...", "...senza animali domestici, bevono 2 sorsi."));
                card_list.add(new Card("Tutte le persone...", "...che non studiano informatica, bevono 2 sorsi."));
                card_list.add(new Card("Tutte le persone...", "...che hanno fratelli o sorelle più piccoli di loro, bevono 2 sorsi."));
                card_list.add(new Card("Happy Hour", "Se ti fai uno shot, puoi donare uno shot a 4 altri partecipanti. Questo lo offre la casa."));
                card_list.add(new Card("Happy Hour", "Se ti fai uno shot, puoi donare uno shot a 4 altri partecipanti. Questo lo offre la casa."));
                card_list.add(new Card("Classicone", "Té alla pesca o té al limone? Beve la minoranza."));
                card_list.add(new Card("Tutte le persone...", "...che si sono rotte un osso nella vita, bevono 2 sorsi in onore della sanità."));
                //card_list.add(new Card("Jukebox", "Pensa ad una canzone famosa e riproducila senza usare le parole, bensì imitando il verso di un animale. Chi azzecca il titolo può donare 4 sorsi."));
                card_list.add(new Card("Jukebox", "Pensa ad una canzone famosa e riproducila senza usare le parole, bensì imitando il verso di un animale. Chi azzecca il titolo può donare 4 sorsi."));
                //card_list.add(new Card("Mi chiamo Bond, Massimiliano Bond", "Fino alla fine del gioco, se vuoi chiamare un altro sfidante devi chiamarlo con un nomignolo. Il distratto che si dimentica di chiamarlo con il nomignolo, beve 2 sorsi."));
                //card_list.add(new Card("Il più grande male dell'umanità è...", "A turno, ognuno dice qual è secondo lui/lei il piû grande problema dell'umanitâ. Chi condivide quanto detto beve 1 sorso."));
                card_list.add(new Card("Tutte le persone...", "...che hanno il giorno del compleanno pari, bevono 1 sorso."));
                card_list.add(new Card("Cappellino", "Le persone che indossano un cappellino o un berretto bevono un sorso."));
                //card_list.add(new Card("La prima cosa che guardi", "La prima cosa che guardi in un(a) ragazzo/a? A turno ognuno dice la sua. Se sei d'accordo con qualcun'altro bevi 1 sorso."));
                //card_list.add(new Card("Obbligo o verità", "Puoi scagliare un \"Obbligo o verità\" ad un altro concorrente. Tutti, tranne la/o sfidata/o, bevono un sorso."));
                //card_list.add(new Card("Obbligo o verità", "Puoi scagliare un \"Obbligo o verità\" ad un altro concorrente. Tutti, tranne la/o sfidata/o, bevono un sorso."));
                //card_list.add(new Card("Ah, il cambiamento", "Cosa vorresti cambiare nella tua vita? A turno ognuno dice la sua (non si è obbligati). Tutti bevono 1 sorso."));
                //card_list.add(new Card("Il gallo", "Per 5 minuti, ogni volta che parli, mettere nella tua frase almeno un \"Chicchirichì\". Se ti dimentichi e vieni richiamato, bevi 1 sorso.", 300));
                card_list.add(new Card("Sarabanda", "Scegli una canzone da far ascoltare agli altri. Chi indovina titolo e interprete, può distribuire 3 sorsi."));
                //card_list.add(new Card("Momento imbarazzante", "A ruota libera, chi racconta un momento imbarazzante della propria vita, può distribuire 2 sorsi."));
                //card_list.add(new Card("La casa de papel", "Scegli 4 persone del gruppo che porteresti con te per una rapina in banca. Specifica il motivo/il ruolo nella rapina e il loro nome d'arte. I rapinatori bevono 1 sorso come brindisi al piano."));
                card_list.add(new Card("Split or Steal", "Scegli l'avversario che dovrà sfidarti. Avete 10 secondi fare la vostra scelta tra SPLIT oppure STEAL. Allo scadere del tempo, comunicate la vostra scelta nello stesso momento. Se scegliete entrambi SPLIT, potete distribuire 1 sorso a testa. Se uno sceglie SPLIT e l'altro STEAL, chi ha scelto STEAL distribuisce 4 sorsi, l'avversario niente. Se entrambi scegliete STEAL, vi fate uno shot a testa, la bevanda sarà scelta dagli altri giocatori."));
                card_list.add(new Card("Strega comanda colore", "Puoi scegliere 2 colori. Chi ha come colore preferito uno dei 2 colori, beve 2 sorsi. Strega comanda colore....."));
                card_list.add(new Card("Nomi, cose, città", "Pensa ad una lettera dell'alfabeto. Munitevi di carta e penna. In 1 minuto, ognuno dovrà trovare una riposta che inizi con quella lettera per le categorie che seguono. Chi non ne trova beve 2 sorsi, chi condivide la risposta con altre persone, beve 1 sorso. \nCategorie:\n1. Nomi\n2. Oggetti trovati in classe\n3. Nazioni europee\n4. Marche famose\n5. Animali"));
                */

                try {
                    JSONObject obj = new JSONObject(loadJSONFromAsset());
                    JSONArray m_jArray = obj.getJSONArray("cards");
                    ArrayList<HashMap<String, Object>> formList = new ArrayList<>();
                    HashMap<String, Object> m_li;

                    for (int i = 0; i < m_jArray.length(); i++) {
                        JSONObject jo_inside = m_jArray.getJSONObject(i);
                        String title = jo_inside.getString("title");
                        String text = jo_inside.getString("text");
                        Double time = jo_inside.getDouble("time");

                        m_li = new HashMap<String, Object>();
                        m_li.put("title", title);
                        m_li.put("text", text);
                        m_li.put("time", time);

                        formList.add(m_li);
                    }

                } catch (org.json.JSONException ex) {
                    System.out.println(ex.fillInStackTrace());
                }


                break;



            case ENGLISH:
                card_list.add(new Card("Foreign languages", "You have to speak a foreign language for 5 minutes. Everytime you say something in your own language, you drink 2 sips.", time));
                card_list.add(new Card("X Factor", "The person who drew the card has to perform as a singer (alone or in group). If the performance is good enough, everyone sips twice, otherwise the singer drinks a shot."));
                card_list.add(new Card("Cascade","Everybody starts drinking. As soon as the person on your left stops drinking, you can stop as well (or keep drinking). The game starts from the person who drew the card!"));
                card_list.add(new Card("Cascade","Everybody starts drinking. As soon as the person on your left stops drinking, you can stop as well (or keep drinking). The game starts from the person who drew the card!"));
                card_list.add(new Card("Happy Hour!","If you drink a shot, you can decide 4 more players that will drink a shot with you. This is on the house!"));
                card_list.add(new Card("Whisper challenge","Choose a partner. While your partner is listening to loud music, whisper to him a sentence at your choice. If by 1 minute your partner guesses, you can distribute 4 sips, otherwise you and your partner drink 2 sips each."));
                break;
        }

        Collections.shuffle(card_list);

        for (Card card : card_list) {
            cards.push(card);
        }

        timer_title_left.setVisibility(View.GONE);
        timer_title_right.setVisibility(View.GONE);

        showTitle();
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("ITA_cards.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            System.out.println("File not found! Try changing the name or to locate the file.");
        }
        return json;
    }



    private void get_card() {
        card_text.setVisibility(View.VISIBLE);
        card_icon.setVisibility(View.VISIBLE);
        small_title.setVisibility(View.VISIBLE);
        card_title.setVisibility(View.GONE);
        small_title.setText(playing_card.getTitle());
        card_text.setText(playing_card.getText());

        card_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playing_card.HasTimer()) {
                    if (timer_title_left.getText().equals("")) {
                        timer_title_left.setVisibility(View.VISIBLE);
                        playing_card.setTextView(timer_title_left, timer_time_left);
                        playing_card.startTimer();
                    } else if (timer_title_right.getText().equals("")) {
                        timer_title_right.setVisibility(View.VISIBLE);
                        playing_card.setTextView(timer_title_right, timer_time_right);
                        playing_card.startTimer();
                    }
                }
                showTitle();
            }
        });
    }


    public static void setLanguage(Language language) {
        chosen_language = language;
    }


    private int count = 0;

    private void showTitle() {
        if (cards.isEmpty()) {
            card_list.clear();
            super.startActivity(new Intent(Ninety_cards.this, FinalScreen.class));
        } else {
            playing_card = cards.pop();
            count++;
            card_text.setVisibility(View.GONE);
            card_icon.setVisibility(View.GONE);
            small_title.setVisibility(View.GONE);
            card_title.setVisibility(View.VISIBLE);

            card_title.setText(playing_card.getTitle());
            message_number.setText(count + "/" + Card.count);
        }
    }

    public void screenTapped(View view) {
        get_card();
        card_text.scrollTo(0, 0);
    }

    @Override
    public void onBackPressed() {
        card_text.setVisibility(View.GONE);
        card_icon.setVisibility(View.GONE);
        small_title.setVisibility(View.GONE);
        card_title.setVisibility(View.VISIBLE);

        card_title.setText(playing_card.getTitle());
    }
}