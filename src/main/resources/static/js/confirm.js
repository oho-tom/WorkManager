'use strict';

function confirmMessage(){
	if(window.confirm('実行してよろしいですか？')){ // 確認ダイアログを表示
		return true; // 「OK」時は送信を実行
	} else { // 「キャンセル」時の処理
		return false; // 送信を中止
	}
}
