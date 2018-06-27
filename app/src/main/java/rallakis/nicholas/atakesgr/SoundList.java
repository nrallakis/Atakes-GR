package rallakis.nicholas.atakesgr;

import java.util.ArrayList;
import java.util.Arrays;

public class SoundList {

    public static final int NO_BACKGROUND = -1;

    private static Sound[] chiosSounds = new Sound[] {
            new Sound("Ξύλο παντού!", R.raw.xylo_pantou),
            new Sound("Μπάμ μπάμ μπάμ!", R.raw.bambambam),
            new Sound("Μα**κα!", R.raw.malaka),
            new Sound("Να πεθάνει το πρωί", R.raw.na_pethanei_to_proi),
            new Sound("Ρε όξωωω", R.raw.re_okso),
            new Sound("Θέλω κι άλλα!", R.raw.thelw_kialla),
            new Sound("Τον π**στη!", R.raw.ton_pousti),
            new Sound("Τους ήρωες", R.raw.tous_hrwes),
            new Sound("Υποστηρικτής", R.raw.ypostiriktis),
            new Sound("Σίμος", R.raw.simos),
            new Sound("Χίος-Αλέφαντος", R.raw.chios_alefantos),
            new Sound("Κωλόγρια", R.raw.kologria),
            new Sound("Μαρκάτος", R.raw.markatos),
            new Sound("Προσοχή ρε μα**κα!", R.raw.prosoxi_re_malaka),
            new Sound("Αθυροστομος", R.raw.xios_athirostomos),
            new Sound("Έχω δει πολλά", R.raw.xios_exw_dei_polla),
            new Sound("Πρόσεχε καλά παππά!", R.raw.prosexe_kala_pappa_xios),
            new Sound("Τζάνης", R.raw.xios_tzanis)
    };

    private static Sound[] tsoukalasSounds = new Sound[] {
            new Sound("Με ανώμαλους, δεν μιλάω!", R.raw.me_anomalous_den_milaw),
            new Sound("Πίπης, Πίπα!", R.raw.pipis_pipa),
            new Sound("Κιτρινόμαυρος τιμωρός", R.raw.kitrinomayros_timoros),
            new Sound("Πουτ**κεφαλος", R.raw.poutsokefalos),
            new Sound("Ο ψεύτης", R.raw.o_pseftis),
            new Sound("Michel, this is Πειραιάς!", R.raw.michel_this_is_peiraias),
            new Sound("Με ποιόν να μιλήσω;", R.raw.me_poion_na_milisw),
            new Sound("Βράζει και χύνεται", R.raw.vrazi_kai_xinetai),
            new Sound("Ο αγγούρης", R.raw.agouris),
            new Sound("Ο Ιερώνυμος", R.raw.ieronimos),
            new Sound("Ο Σουλειμάν", R.raw.souleiman),
            new Sound("Ο Ξεκώλογλου", R.raw.o_ksekologlou),
            new Sound("Δεν έχετε δικαίωμα να κλείνετε τις γραμμές", R.raw.den_exete_dikaioma_na_kleinete_tis_grammes),
            new Sound("Κλωτσιά Άκη", R.raw.klotsia_aki),
            new Sound("Αριανός", R.raw.tsoukalas_arianos)
    };

    private static Sound[] newSounds = new Sound[] {
            new Sound("Fast & furious", R.raw.fast_and_furius),
            new Sound("Χατζηγεωργίου-Καλάθης", R.raw.hatzi_kalathis),
            new Sound("Ιωάννου-Άγιος Γεώργιος", R.raw.ioannou_agios_georgios),
            new Sound("Ιωάννου-Big Papapapa", R.raw.ioannou_big_papapa),
            new Sound("Ιωάννου-Σλούκι Λουκ", R.raw.ioannou_slouki_louk),
            new Sound("Ιωάννου-Την Ελλάδα θα τη σέβεστε", R.raw.ioannou_tha_seveste)
    };

    private static Sound[] basketSounds = new Sound[] {
            new Sound("Nick the quick και Fast & furious", R.raw.fast_and_furius),
            new Sound("Χατζηγεωργίου-Καλάθης", R.raw.hatzi_kalathis),
            new Sound("Ιωάννου-Άγιος Γεώργιος", R.raw.ioannou_agios_georgios),
            new Sound("Ιωάννου-Big Papapapa", R.raw.ioannou_big_papapa),
            new Sound("Ιωάννου-Σλούκι Λουκ", R.raw.ioannou_slouki_louk),
            new Sound("Ιωάννου-Την Ελλάδα θα τη σέβεστε", R.raw.ioannou_tha_seveste),
            new Sound("Ιωάννου-Μακρινό rebound", R.raw.ioannou_makrino_rebound),
            new Sound("Ιωάννου-On fire", R.raw.ioannou_on_fire),
            new Sound("Άνθιμος-μπάσκετ", R.raw.antimos_basket),
    };

    private static Sound[] chatzistefanouSounds = new Sound[] {
            new Sound("Τσόλι", R.raw.xatzistefanou_ai_g_re_tsoli),
            new Sound("Ηχομετρητής", R.raw.xatzistefanou_ixometritis),
            new Sound("Μεσημεριανή εκπομπή", R.raw.xatzistefanou_mesimeriani_ekpompi),
            new Sound("Να μας κλάσουν τα @@", R.raw.xatzistefanou_na_mas_klasoun_ta_arx),
            new Sound("Παλαιό φάληρο", R.raw.xatzistefanou_palaiofaliro),
            new Sound("Έχω φτύσει αίμα", R.raw.exw_ftysei_aima)
    };

    private static Sound[] otherSounds = new Sound[] {
            new Sound("Άδωνης-Ζερ smartphone", R.raw.adonis_zer_smartphone),
            new Sound("Άδωνης-Ζερ tablet", R.raw.adonis_zer_tablet),
            new Sound("Άδωνης-Τα λιγουρεύεστε!", R.raw.ta_ligoureyeste),
            new Sound("Αλέφαντος-μάθε μπαλίτσα", R.raw.alefantos_mathe_balitsa),
            new Sound("Αλέφαντος-Παπ παπ παπ!", R.raw.alefantos_papapap),
            new Sound("Αλέφαντος-Διαταγή Αλέφαντου", R.raw.diatagi_alefantou),
            new Sound("Ευτυχισμένοι μαζι-Αστράφτει το σπαθί του καβαλάρη", R.raw.eytyxismenoimazi_astraftei_to_spathi),

            new Sound("Γεωργούτζος-ποτήρι", R.raw.georgoutzos_potiri),
            new Sound("Γεωργουντζος κουφός", R.raw.georgoutzos_koufosi),
            new Sound("Καλώς τα παιδιά", R.raw.kalws_ta_paidia_3_0),
            new Sound("Κύριος αυγολέμονος", R.raw.kyrios_augolemonos_archontous),
            new Sound("Την παναγία!", R.raw.panagia),
            new Sound("Χατζηγεωργίου", R.raw.chatzigeorgiou),
            new Sound("Έφη Θώδη", R.raw.efi_thodi_ston_leuko_oiko),
            new Sound("Πως γκενιν ατό;", R.raw.pos_gkenin_ato),
            new Sound("Θα σε τι γκαμ*σω τη μπουφάν", R.raw.tha_se_ti_gamiso_ti_mpoufan),
            new Sound("Θεοχάρης-Κατά τα έργα σου(RIP)", R.raw.theoharis_kata_ta_erga_sou_rip),
            new Sound("Τσαρτάς-Ποτήρι", R.raw.tsartsas_potiri_nero),
            new Sound("Φύγε Λύμπε!!", R.raw.fyge_lympe)
    };

    public static PlayLists get(int listName) {
        return PlayLists.values()[listName];
    }


    public static int getSoundListsCount() {
        return PlayLists.values().length;
    }

    public static Sound getRandomSound() {
        ArrayList<Sound> allSounds = new ArrayList<>();
        for (PlayLists list : PlayLists.values()) {
            allSounds.addAll(Arrays.asList(list.getSounds()));
        }
        int randomIndex = (int) (Math.random() * allSounds.size());
        return allSounds.get(randomIndex);
    }

    enum PlayLists {
        NEWATAKES(newSounds, NO_BACKGROUND, "από τις καινούργιες"),
        CHIOS(chiosSounds, R.drawable.chios_background, "του Χίου"),
        TSOUKALAS(tsoukalasSounds, R.drawable.tsoukalas_background, "του Τσουκαλά"),
        BASKET(basketSounds, R.drawable.ioannou_background, "από το μπάσκετ"),
        CHATZISTEFANOU(chatzistefanouSounds, R.drawable.chatzistefanou_background, "του Χατζηστεφάνου"),
        OTHER(otherSounds, NO_BACKGROUND, "από διάφορα");

        private Sound[] sounds;
        private int background;
        private String name;

        PlayLists(Sound[] sounds, int background, String name) {
            this.sounds = sounds;
            this.background = background;
            this.name = name;
        }

        Sound[] getSounds() {
            return sounds;
        }

        Sound getSound(int index) {
            if (index < 0 || index >= sounds.length) {
                throw new IllegalArgumentException("The index should be between 0 and " + (sounds.length-1));
            }
            return getSounds()[index];
        }

        String getName() {
            return name;
        }

        int getBackground() {
            return background;
        }

        int getCount() {
            return sounds.length;
        }
    }
}
