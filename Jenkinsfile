pipeline{
	agent any
	
	tools{
		maven 'Maven'
	}

	stages{

		stage('Clone'){
			steps{
				git branch: 'main',
                		url: 'https://github.com/Gugashri30/Expense_Tracker_Full_Stack_Monolithic__Application.git'
			}
		}
		stage('Build'){
			steps{
			   dir('Backend_SET/smart_expense_tracker_Backend') {
                    		sh 'mvn clean package -DskipTests'
                	   }
			}
		}
		 stage('Archive Artifact') {
            		steps {
                		archiveArtifacts artifacts: 'Backend_SET/smart_expense_tracker_Backend/target/*.jar', fingerprint: true
            		}
        	}

        	stage('Deploy') {
    			 steps {
        			sh '''
        			mkdir -p /workspace/Deployment/ExpenseTracker
       				cp Backend_SET/smart_expense_tracker_Backend/target/*.jar \
        			/workspace/Deployment/ExpenseTracker/
        			'''
    			}
		}
    	}

    post {
        success { 
            echo 'Pipeline Completed Successfully'
        }

        failure {
            echo 'Pipeline Failed'
        }
    }

}