<?php

namespace App\Presenters;

use Nette,
    Nette\Application\UI\Form;


/**
 * Homepage presenter.
 */
class HomepagePresenter extends BasePresenter
{

	public function renderDefault()
	{
		$this->template->anyVariable = 'any value';
	}

    protected function createComponentSearchForm()
    {
        $form = new Form;
        $form->addText('toSearch')
            ->setAttribute('id', 'tags');
        $form->addSubmit('find', 'Find');

        $form->onSuccess[] = array($this, 'searchFormSucceeded');
        return $form;
    }

    //
    public function searchFormSucceeded($form, $values)
    {
        // ..
        $this->flashMessage('Nalezeno');
        //$this->redirect('Homepage:', array("id_grammar", 123));
        $this->redirect("Search:list", array("search" => $values->toSearch));
    }

}
