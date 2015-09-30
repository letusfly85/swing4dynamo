package swing

import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.services.dynamodbv2.document.{Item, Table, DynamoDB}
import com.amazonaws.services.dynamodbv2.model.{ScanResult, ScanRequest}

object Main {

	val dynamo: DynamoDB = new DynamoDB(new AmazonDynamoDBClient(
		new ProfileCredentialsProvider())
	)

	def main(args: Array[String]) {
		val client = new AmazonDynamoDBClient(new ProfileCredentialsProvider())
		client.setEndpoint("http://dynamodb.ap-northeast-1.amazonaws.com")

		val scanRequest: ScanRequest = new ScanRequest().withTableName("**********")
		val result: ScanResult = client.scan(scanRequest)

		result.getItems.toArray.toList.foreach(println)
	}

	/*
	def getBook(id: String, tableName: String): Unit = {
		val table: Table = dynamo.getTable(tableName)

		println(id)
		val item: Item = table.getItem("user_id", id)

		println("GetItem: printing results...")
		println(item.toJSONPretty())
	}
	*/

}