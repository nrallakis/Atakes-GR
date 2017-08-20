package rallakis.nicholas.atakesgr;

import java.util.ArrayList;
import java.util.Arrays;

abstract public class SoundList {

    public static final int CHIOS = 0;
    public static final int TSOUKALAS = 1;
    public static final int OTHER = 2;
    public static final int NO_BACKGROUND = -1;

    public Sound getSound(int index) {
        if (index < 0 || index >= getCount()) {
            throw new IllegalArgumentException("The index should be between 0 and " + (getCount()-1));
        }
        return getSounds()[index];
    }

    public int getCount() {
        return getSounds().length;
    }

    abstract Sound[] getSounds();

    abstract int getBackground();

    abstract String getName();

    /* Contains a list of sounds objects*/
    private static SoundList[] allSoundLists = {
            new Chios(),
            new Tsoukalas(),
            new Other()
    };

    public static SoundList get(int listName) {
        return allSoundLists[listName];
    }

    public static int getSoundListsCount() {
        return allSoundLists.length;
    }

    private static class Chios extends SoundList {
        @Override
        Sound[] getSounds() {
            return new Sound[] {
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
                    new Sound("Προσοχή ρε μα**κα!", R.raw.prosoxi_re_malaka)
            };
        }

        @Override
        int getBackground() {
            return R.drawable.chios_background;
        }

        @Override
        String getName() {
            return "Χίου";
        }
    }

    private static class Tsoukalas extends SoundList {
        @Override
        Sound[] getSounds() {
            return new Sound[] {
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
                    new Sound("Ο Ξεκώλογλου", R.raw.o_ksekologlou)
            };
        }

        @Override
        int getBackground() {
            return R.drawable.tsoukalas_background;
        }

        @Override
        String getName() {
            return "Τσουκαλά";
        }
    }

    private static class Other extends SoundList {
        @Override
        Sound[] getSounds() {
            return new Sound[] {
                    new Sound("Άδωνης-Ζερ smartphone", R.raw.adonis_zer_smartphone),
                    new Sound("Άδωνης-Ζερ tablet", R.raw.adonis_zer_tablet),
                    new Sound("Άδωνης-Τα λιγουρεύεστε!", R.raw.ta_ligoureyeste),
                    new Sound("Αλέφαντος-μάθε μπαλίτσα", R.raw.alefantos_mathe_balitsa),
                    new Sound("Αλέφαντος-Παπ παπ παπ!", R.raw.alefantos_papapap),
                    new Sound("Ευτυχισμένοι μαζι-Αστράφτει το σπαθί του καβαλάρη", R.raw.eytyxismenoimazi_astraftei_to_spathi),
                    new Sound("Άντιμος-μπάσκετ", R.raw.antimos_basket),
                    new Sound("Γεωργούτζος-ποτήρι", R.raw.georgoutzos_potiri),
                    new Sound("Καλώς τα παιδιά", R.raw.kalws_ta_paidia_3_0),
                    new Sound("Κύριος αυγολέμονος", R.raw.kyrios_augolemonos_archontous),
                    new Sound("Την παναγία!", R.raw.panagia)
            };
        }

        @Override
        int getBackground() {
            return NO_BACKGROUND;
        }

        @Override
        String getName() {
            return "Διάφορα";
        }
    }

    public static Sound getRandomSound() {
        ArrayList<Sound> allSounds = new ArrayList<>();
        for (SoundList list : allSoundLists) {
            allSounds.addAll(Arrays.asList(list.getSounds()));
        }
        int randomIndex = (int) (Math.random() * allSounds.size());
        return allSounds.get(randomIndex);
    }
}
