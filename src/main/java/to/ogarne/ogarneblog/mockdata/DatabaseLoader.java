package to.ogarne.ogarneblog.mockdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import to.ogarne.ogarneblog.model.Page;
import to.ogarne.ogarneblog.model.Post;
import to.ogarne.ogarneblog.service.CategoryService;
import to.ogarne.ogarneblog.service.PageService;
import to.ogarne.ogarneblog.service.PostService;
import to.ogarne.ogarneblog.service.UserService;

import java.util.Date;

/**
 * Created by jedrz on 17.07.2017.
 */
@Profile("dev")
@Component
public class DatabaseLoader {

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    PostService postService;

    @Autowired
    PageService pageService;


    String[] cats = {"przyklad"};


    public void run() {

        for (int i = 0; i < 20; i++) {
            postService.save(new Post("Ensem candentia Camenis quos coniunx dolet placidis tumidisque",
                    "pierwszy-post" + i,
                    "description",
                    "Lorem markdownum gemmae, sed an requiescit ut omnes, est, per cristae patrium!\n" +
                            "Iuncti nostri capillos ad inquit procorum mora aspicit cladibus Austri temptant\n" +
                            "bibit ad sic madida ingratum virique. Succedere tibi, recurvas *vana* frondator,\n" +
                            "alterius sis veluti, et ruunt et eripuit. **Moverat Acoete**, portasque elabique\n" +
                            "magnoque nondum Achille similis iuvenci, error senectae nymphas paravi, Ide?\n" +
                            "\n" +
                            "@@@\n" +
                            "    koffice_baud_swappable *= switch_wamp;\n" +
                            "    smm_json_virus += 4 - 2;\n" +
                            "    touchscreenWeb += bps_rfid;\n" +
                            "    if (bcc(4) < remote_powerpoint_http(-1, cd_spam_animated,\n" +
                            "            multimediaHardware)) {\n" +
                            "        data_blog_card(offlineEideJson(42, permalinkAnalystCycle), flash);\n" +
                            "    }\n" +
                            "    association_console_tag = home.cell_noc(multicastingUpload(middleware_boot,\n" +
                            "            lock_clip_jumper * pseudocode, 60));\n" +
                            "\n" +
                            "Ensem candentia Camenis quos coniunx dolet placidis tumidisque talisque tergoris\n" +
                            "incunabula contigit **praefixaque factum**: Venerem! Simul his non crepuscula,\n" +
                            "castaque, at meris, fiducia umor non. Pietate ecquid haec incubat sententia\n" +
                            "domui in caput ab quorum. Duo terribilesque ista nobiliumque leve; me animo ut\n" +
                            "silendo, ede. Inputet adhuc.\n" +
                            "\n" +
                            "Recepto merguntque leni Amathunta quibus bicorni, precor, amplexu bibit arbore\n" +
                            "domus Argiodus obortas scelerate. Laevam prodere dummodo, in adhibent imperet\n" +
                            "hic opusque conubia cum tu. Iurasse *virgineas*, tua litora, sanguine ille,\n" +
                            "capillos facinus resonant vulneribus taurorum viriles rata harenae vero dicta\n" +
                            "*iraeque*. Et quod hanc illa delubraque labori, ego **male furiale**, at suum.\n" +
                            "\n" +
                            "1. Officium tuos nec est videnda mihi\n" +
                            "2. Locum index adiecisset ab motis umbras potenti\n" +
                            "3. Illas quodcumque\n" +
                            "4. Exerces omine\n" +
                            "5. Bene victoremque\n" +
                            "6. Portae iaculum coronat\n" +
                            "\n" +
                            "Voces flentemque, feretrumque arma tumulum quondam aquis, Tritonia mori. Nec\n" +
                            "formosior; hebes pars praetenta, paenituisse usum vultumque te Quas arsit\n" +
                            "gratantibus velo. Quod domui *certans* semper et bene quae et Aoniis ille saxa\n" +
                            "amans, paratus.",
                    userService.findByUsername("jedrzej"),
                    categoryService.findByName("przyklad"),
                    new Date(),
                    true));


            postService.save(new Post("Iuncti nostri capillos ad inquit procorum",
                    "iuncti-ad-inquit-procorum" + i,
                    "Honore **iurasse** Parrhasis ab innixus, cum docebo, et tamen: latrantibus et\n" +
                            "indigno! Poenaeque cuti causa, de parsque, non dicere medium, si ore iam. Futuro\n" +
                            "sedens fera iure bis Alba avidaeque visum et cecidere sim Echion, ad traxit",
                    "Lorem markdownum *quem* Cyllenius alumno erat repertum nitidaque, diligis ullis\n" +
                            "*callem*; rapinae! Sed *ipse sed quippe*, vel auras arma, ferro exiguas.\n" +
                            "@@@\n" +
                            "\n" +
                            "1. Hippodamen contenta cervus meritis laborent\n" +
                            "2. Ferrea et ficta culpae inmitibus descendi si\n" +
                            "3. Pudor sero confesso at cornuaque pater iamque\n" +
                            "4. Pressus hactenus a pater formam cuspidis\n" +
                            "5. Debere memori\n" +
                            "6. Velamenta Ericthonio rupti\n" +
                            "\n" +
                            "Honore **iurasse** Parrhasis ab innixus, cum docebo, et tamen: latrantibus et\n" +
                            "indigno! Poenaeque cuti causa, de parsque, non dicere medium, si ore iam. Futuro\n" +
                            "sedens fera iure bis Alba avidaeque visum et cecidere sim Echion, ad traxit\n" +
                            "Morphea preces propior Elysiasque. Thebae dea remisit vallis quam tacti nec,\n" +
                            "tamen senis antiquum vultus, non.\n" +
                            "\n" +
                            "    click_big = -4;\n" +
                            "    if (iteration_soap_golden) {\n" +
                            "        crt_spider_ugc = cycle;\n" +
                            "        san_copy(bare_down_p, stack(masterSystemBar));\n" +
                            "    }\n" +
                            "    var consolePoint = compression.macintoshVirtualScript.file_commerce(\n" +
                            "            cdJumperProgram);\n" +
                            "    multiprocessing_bar_payload(wep(bar));\n" +
                            "\n" +
                            "Aliqua Parnasi demitteret ferre aeratae quodsi, succedere prior, sunt mutua qua.\n" +
                            "Bibendo suos ense urbe involvitur satis est excussae hoc Learchum umeris,\n" +
                            "proque. Quae est accusoque palles [utque nostrae](http://www.tura.org/) surgit\n" +
                            "iactatam? Ab ille habebit inmutatque iura, cernitis ab habet, sermonibus certe,\n" +
                            "ore vela facinus trado, Baucide.\n" +
                            "\n" +
                            "- Silvae perlucentes arcus\n" +
                            "- Resonare post exiguam adhibere delatus templum placebant\n" +
                            "- Aurigam latratu moratum\n" +
                            "\n" +
                            "Incustoditam artus; ore natalis, et moverat colat fecissent. *Animam est* anteit\n" +
                            "faciem, quaeris **de**, sub simulat esse patiar cantus praeter. Dum quove deus\n" +
                            "novandi totusque, dextra, antra redolentia, crimen, Sabinis! Vela *mundi*.",
                    userService.findByUsername("jedrzej"),
                    categoryService.findByName("przyklad"),
                    new Date(),
                    true));


            postService.save(new Post("Iuncti nostri capillos ad inquit procorum",
                    "iuncti-nostri-capillos-ad-inquit-procorum" + i,
                    "Honore **iurasse** Parrhasis ab innixus, cum docebo, et tamen: latrantibus et\n" +
                            "indigno! Poenaeque cuti causa, de parsque, non dicere medium, si ore iam. Futuro\n" +
                            "sedens fera iure bis Alba avidaeque visum et cecidere sim Echion, ad traxit",
                    "Quodque fontibus. Tria refer hamo furoris genetrix nocuere cantusque recumbit\n" +
                            "positoque **vetat** coniuge diemque; iactu salutis. Volubilibus fert tamen\n" +
                            "verbis, punica vos per omnis, viam meo mihi tellure, apta?\n" +
                            "@@@\n" +
                            "\n" +
                            "- Vocem sed pia dicere erat ingenti\n" +
                            "- Pars ipse medio effetum\n" +
                            "- Maius et suos ore\n" +
                            "\n" +
                            "Potestas pugna ruit est tu vestis et desertum, umquam in nec moenibus, instruit.\n" +
                            "Inpositaque utque creditus inplevit refugit avidis festis Priamidenque vimque\n" +
                            "quam penetravit enixa! Medio Circen primus tamen parenti crocique geminato,\n" +
                            "acceptos Hersilie ensem inque coloni quinque, at!\n" +
                            "\n" +
                            "    if (supply.camelcaseKeyboard(hsf) >= ipv) {\n" +
                            "        numRootkit = 3;\n" +
                            "    } else {\n" +
                            "        ip.path_ics = namespaceEideDrop;\n" +
                            "        prom(tutorial_animated_cd, transistor, dvZero);\n" +
                            "    }\n" +
                            "    if (system(io_dfs_file.pageSchemaToken(cloudVirtualJoystick,\n" +
                            "            multimedia_shift_hertz, hard_zero))) {\n" +
                            "        website_up = isoWavePassive(component_cpu_page, defaultFloodSite(data,\n" +
                            "                bus_host_pptp, 34));\n" +
                            "        core.software(4, logic_cyberspace_stick, sector_requirements);\n" +
                            "        software = camera_rup_user(snow_ansi_pop, -2 + smart_friend);\n" +
                            "    } else {\n" +
                            "        windows(46, hdv + input_fragmentation_undo);\n" +
                            "    }\n" +
                            "    troubleshooting(aiff_layout_qbe(memoryBarRaster, heat_srgb_io / clip_media),\n" +
                            "            key.clob.serverIde(ddr_adware_gnutella, wins_adapter(smartphone,\n" +
                            "            thyristor_markup_servlet, 1)));\n" +
                            "    if (open < cellGnutella) {\n" +
                            "        vlb_adware(southbridge_stack_ripping);\n" +
                            "        usSearchOffline.teraflops_card = postBar;\n" +
                            "    } else {\n" +
                            "        multiprocessingHardBarcraft(storageSsdData);\n" +
                            "        point_permalink(3);\n" +
                            "        mail = nic_mysql_backside(virtualizationCopy, page_hdd);\n" +
                            "    }\n" +
                            "    computer += 5;\n" +
                            "\n" +
                            "Est deus animoque negabo feci nuper fulsit equorum et mittor maturus siccatque\n" +
                            "laeta ales dedit temptanti. Dixi retro modo solet cursus rara fuit modumque sua\n" +
                            "quinos quod, **nescis aevi sunt** sub.\n" +
                            "\n" +
                            "Alasque dat iuventae tibi simplex fuerunt coetu ab humum: natus acervos\n" +
                            "carissime. Tellure Marte dieque heros qua sed est aurum pius utque in exuritque\n" +
                            "superabat sceptri coniectum Oeten exemplum.",
                    userService.findByUsername("jedrzej"),
                    categoryService.findByName("przyklad"),
                    new Date(),
                    true));
        }



        pageService.save(new Page("Linki", "linki", "description", "Lorem markdownum gestasset et ait egreditur inposuit, conde te mansit capiti\n" +
                "nullo. Utque umbram, tangeret in curam caelum tibi utque cognoscite et quoque,\n" +
                "abscessisse. Cum vero concordant, limen [chlamydis\n" +
                "obscena](http://www.volucres.io/prohibereplura), sparserat et vidit et patulo\n" +
                "resupinus hunc. Facitis vidi humo voti iaculis Hippotaden alma. Eminet imago\n" +
                "errant obstipuere orta et **credunt altos**.\n" +
                "\n" +
                "    wysiwyg_petabyte_minisite = powerpoint;\n" +
                "    extensionEncodingFinder /= tftpBaudBitmap(partitionPayload /\n" +
                "            flatbed_raid_regular);\n" +
                "    if (google(whiteDslam)) {\n" +
                "        statusXp = cgi_mca_cgi(addErgonomicsFlowchart);\n" +
                "        lamp(domainMemoryWord, -3 + menu_bloatware_baseband);\n" +
                "    }\n" +
                "    ppm += imap;\n" +
                "\n" +
                "Morte se mei adflavit ponto est et clausura poenam, isque tenuit dicentem horas,\n" +
                "[viribus ut](http://vasti.net/). Fabricata [satis Medon\n" +
                "blanditias](http://litora.net/), altoque ne gestae auro dedisti levia lacrimis\n" +
                "enim? Indoluit vidistis victor tantus ferrum, quo Latonia terrae nitidum et.\n" +
                "Cibo tum atque, huc arce *carmina volanti*, iamque planissima gerit ingenti\n" +
                "propiore locum, ora.\n" +
                "\n" +
                "Diebus mollesque collibus virtus. Alterius litoraque inde, arto, est nullique si\n" +
                "ensis, demens uberibus ut. Puerum mortemque at sed attrahite praecedentem factus\n" +
                "supernum molibar. Formae Ceyx arte enim *captat*; et concava! **Probant** per\n" +
                "fera plura luce cervice cineres." ));

        pageService.save(new Page("O mnie", "o-mnie", "description", "\n" +
                "Refert gaudetque culpavit, gravitate desunt et a filia est sed turbamve rimas\n" +
                "occiduo macies. Et forma, monte concussit, fatisque est modo rursus discedunt\n" +
                "**gavisus more suos**? Auxilium magni.\n" +
                "\n" +
                "1. Natarum quae ista quia\n" +
                "2. Nam dapibus horrentia in Cepheus repetenda incursu\n" +
                "3. Ima furtum Gange\n" +
                "4. Adducor quid hortaturque genetrix\n" +
                "5. Martius gelidis\n" +
                "6. Addat hasta nocte\n" +
                "\n" +
                "Milia horrea, et [gravitate loquentem desinit](http://sed-ille.org/fueritparat).\n" +
                "Superos patet superatus umenti sidera munera, umbras hanc: veneni! Me caedis\n" +
                "unguibus eurytus inrorant praestant **petebat perituraque** tangam Phoebus.\n" +
                "Latebris ignesque leones si interea incedere tenebras aquarum tantae functaque\n" +
                "aliisque Phrygum? Oro quo spirarunt terrae, has tendens bello.\n" +
                "\n" +
                "Huic via pedum tui. Humanam similisque, aequa Elin, serpentis siqua consedit\n" +
                "ritus occidit, remorum? Gracili adspexit, armenta Baucis virilem sibi quodcumque\n" +
                "**flens**, me erat [luctor vocandus](http://natis.io/). Ait si recusat: quam\n" +
                "hominum herba veniensque **auctorem novat**.\n" +
                "\n" +
                "Phoebe in ille illo, contigero, pictas sui. Corpore hic se Phaethon murmur\n" +
                "quoque vix egisse prodiga *quaesistis noctis* me filia, adlevat, potuit, in\n" +
                "[fulvum](http://www.gentem-tenui.io/). Ea inhaesi postquam est media, Antissa\n" +
                "Iovis tenuit dedit terras."));


    }
}
