package helper;

import com.google.gson.Gson;

import net.sf.json.JSONObject;

public class testCode {
	
	public static void main( String[] args )
    {
        String url = "http://test.sancamap.com/api/1.0.0/wallet_coins.json";
        String auth = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJleHAiOjE1MjA2ODkxMjJ9.2JSVoRag1iic31pfLoCKUYYNz_K3-tgEH_ArlgorNMY";
        
        ServiceResponse response;
//		try {
//			
//			response = RequestHelper.getRequest(url, auth);
//			System.out.println(response.getRawdata());
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//        try {
//			RequestHelper.sendGet();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
//        System.out.println(response.getRawdata());
		
		try {
			String url2 = "http://test.sancamap.com/api/1.0.0/users.json";
			
			
			UserCaMap u1 = new UserCaMap();
			u1.setEmail("tet1@gmail.com");
			u1.setPassword("e9cee71ab932fde863338d08be4de9dfe39ea049bdafb342ce659ec5450b69ae");
			u1.setRecaptcha("03ANcjosoJ66E8B0K5O43C2IF7iTYlY2ZZ7agSTFJhX4A-woltqZwjzPvyha2Zlu5Afv-6v11oD6-X3vQbXOPusD0mMWiUk0MejkGYLKnSvl4aiqDT53NlnCjXFR2It6JZGp9iNguJYimxXdWNHY69m-jRhfN33tSyeqkReFNA22wnEn6PhNNEqDioDRM9mdl0v1ZNUh6QAhTcSNxxNoQUz81_zhe9RuFcu6AKKDKFHHuBBMD-HJCaUsYCynx3SLgAl5lSSkHGiDPlXYeVPYguRB8m83YchCzyCAX40PARyKhAapmqxp8uqZpLMs5U4B29lyQPfctFxrg6K3EWYtIVOOBgYUpB37xd26kHwGBmrVdcvdP8pmIWPtdYw_gEE2rdx7KQ4gPD8vUGy4bPfZJ1EyC9MdHpTLta5IFcMGQtyp8iSKHyzbF4Okw5Wa_RDeIE1qn6sYX21SaB");
			u1.setIsTermAgreed("true");
			UserInfo uInfo1 = new UserInfo();
			uInfo1.setUser(u1);
			
			System.out.println("info1: " + uInfo1.getUser().getEmail());
			
			Gson gson = new Gson();
			String a = gson.toJson(uInfo1);
			
					
			System.out.println("js: " + a);
			
			response =RequestHelper.sendPost(url2, a);
			System.out.println("Rawdata" + response.getRawdata());
			
			// test code
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
