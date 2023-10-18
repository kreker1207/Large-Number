public class Main {
    public static void main(String[] args) {

        String hex1 = "51bf608414ad5726a3c1bec098f77b1b54ffb2787f8d528a74c1d7fde6470ea4";
        String hex2 = "403db8ad88a3932a0b7e8189aed9eeffb8121dfac05c3512fdb396dd73f6331c";
        String[] results = new String[]{
                "1182d8299c0ec40ca8bf3f49362e95e4ecedaf82bfd167988972412095b13db8",
                "51bff8ad9cafd72eabffbfc9beffff",
                "403d208400a113220340808088d16a",
                "ae409f7beb52a8d95c3e413f670884e4ab004d878072ad758b3e280219b8f15b",
                "a37ec108295aae4d47837d8131eef636a9ff64f0ff1aa514e983affbcc8e1d4",
                "146fd821052b55c9a8f06fb0263ddec6d53fec9e1fe354a29d3075ff7991c3a903",
                "i dont know, might be correct",
                "i dont know but its wrong",
                "i dont know but its wrong"
        };

        Tests.testOperation("Test1",hex1,hex2,results);
        String hex3 = "22e962951cb6cd2ce279ab0e2095825c141d48ef3ca9dabf253e38760b57fe03";
        String hex4 = "10e570324e6ffdbc6b9c813dec968d9bad134bc0dbb061530934f4e59c2700b9";
        String[] results1 = new String[]{
                "320c12a752d9309089e52a33cc030fc7b90e032fe719bbec2c0acc939770feba",
                "32ed72b75efffdbcebfdab3fec978fdfbd1f4befffb9fbff2d3efcf79f77febb",
                "00e160100c26cd2c6218810c20948018041148c018a040130134306408070001",
                "dd169d6ae34932d31d8654f1df6a7da3ebe2b710c3562540dac1c789f4a801fc",
                "45d2c52a396d9a59c4f3561c412b04b8283a91de7953b57e4a7c70ec16affc0",
                "8ba58a5472db34b389e6ac3882560970507523bcf2a76afc94f8e1d82d5ff803",
                "i dont know, might be correct",
                "i dont know but its wrong",
                "i dont know but its wrong"
        };
        Tests.testOperation("Test2",hex3,hex4,results1);
        String hex5 = "2077C";
        String hex6 = "1488A";
        String[] results2 = new String[]{
                "34ff6","34ffe","8","df883","40ef","81df0", "35006","BEF2","C072"
        };

        Tests.testOperation("Test3",hex5,hex6,results2);
    }
}